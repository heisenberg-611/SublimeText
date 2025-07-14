#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define BLOCK_SIZE 4096
#define TOTAL_BLOCKS 64
#define SUPERBLOCK_BLOCK 0
#define INODE_BITMAP_BLOCK 1
#define DATA_BITMAP_BLOCK 2
#define INODE_TABLE_START 3
#define INODE_TABLE_BLOCKS 5
#define FIRST_DATA_BLOCK 8
#define INODE_SIZE 256
#define MAX_INODES (INODE_TABLE_BLOCKS * BLOCK_SIZE / INODE_SIZE)

#define MAGIC_NUMBER 0xD34D

typedef struct {
    uint16_t magic;
    uint32_t block_size;
    uint32_t total_blocks;
    uint32_t inode_bitmap_block;
    uint32_t data_bitmap_block;
    uint32_t inode_table_start;
    uint32_t data_block_start;
    uint32_t inode_size;
    uint32_t inode_count;
    uint8_t reserved[4058];
} __attribute__((packed)) Superblock;

typedef struct {
    uint32_t mode;             // 4 Bytes
    uint32_t uid;              // 4 Bytes
    uint32_t gid;              // 4 Bytes
    uint32_t size;             // 4 Bytes
    uint32_t atime;            // 4 Bytes: Last access time
    uint32_t ctime;            // 4 Bytes: Creation time
    uint32_t mtime;            // 4 Bytes: Last modification time
    uint32_t dtime;            // 4 Bytes: Deletion time
    uint32_t links;            // 4 Bytes: Number of hard links
    uint32_t blocks;           // 4 Bytes: Number of data blocks allocated
    uint32_t direct[12];       // 12 Direct block pointers, 12*4 = 48 Bytes
    uint32_t indirect;         // Single Indirect block pointer (4 Bytes)
    uint32_t double_indirect;  // Double Indirect block pointer (4 Bytes)
    uint32_t triple_indirect;  // Triple Indirect block pointer (4 Bytes)
    uint8_t reserved[156];     // Reserved to pad structure to 256 Bytes
} __attribute__((packed)) Inode;

FILE *img;

//read block
void read_block(int block_num, void *buffer) {
    fseek(img, block_num * BLOCK_SIZE, SEEK_SET);
    fread(buffer, 1, BLOCK_SIZE, img);
}

void write_block(int block_num, void *buffer) {
    fseek(img, block_num * BLOCK_SIZE, SEEK_SET);
    fwrite(buffer, 1, BLOCK_SIZE, img);
    fflush(img);
}

//superblock validator
int validate_superblock(Superblock *sb) {
    int valid = 1;
    if (sb->magic != MAGIC_NUMBER) {
        printf("Invalid magic number: 0x%x\n", sb->magic);
        valid = 0;
    }
    if (sb->block_size != BLOCK_SIZE) {
        printf("Invalid block size: %u\n", sb->block_size);
        valid = 0;
    }
    if (sb->total_blocks != TOTAL_BLOCKS) {
        printf("Invalid total block count: %u\n", sb->total_blocks);
        valid = 0;
    }
    if (sb->inode_bitmap_block != INODE_BITMAP_BLOCK) {
        printf("Inode bitmap block should be at %d\n", INODE_BITMAP_BLOCK);
        valid = 0;
    }
    if (sb->data_bitmap_block != DATA_BITMAP_BLOCK) {
        printf("Data bitmap block should be at %d\n", DATA_BITMAP_BLOCK);
        valid = 0;
    }
    if (sb->inode_table_start != INODE_TABLE_START) {
        printf("Inode table should start at block %d\n", INODE_TABLE_START);
        valid = 0;
    }
    if (sb->data_block_start != FIRST_DATA_BLOCK) {
        printf("First data block should be at block %d\n", FIRST_DATA_BLOCK);
        valid = 0;
    }
    if (sb->inode_size != INODE_SIZE) {
        printf("Inode size should be %d\n", INODE_SIZE);
        valid = 0;
    }
    if (sb->inode_count > MAX_INODES) {
        printf("Inode count exceeds max limit (%d)\n", MAX_INODES);
        valid = 0;
    }
    return valid;
}

void process_indirect(uint32_t block_num, int level, bool referenced[]) {
    if (block_num < FIRST_DATA_BLOCK || block_num >= TOTAL_BLOCKS)
        return;
    uint32_t *block_ptrs = malloc(BLOCK_SIZE);
    if (!block_ptrs) {
        perror("malloc failed");
        exit(1);
    }
    read_block(block_num, block_ptrs);
    
    int pointers = BLOCK_SIZE / sizeof(uint32_t);
    for (int i = 0; i < pointers; i++) {
        uint32_t ptr = block_ptrs[i];
        if (ptr == 0)
            continue;
        if (level == 1) {
            if (ptr >= FIRST_DATA_BLOCK && ptr < TOTAL_BLOCKS)
                referenced[ptr] = true;
        } else {
            process_indirect(ptr, level - 1, referenced);
        }
    }
    free(block_ptrs);
}

// Read the inode table from disk.
// The table spans INODE_TABLE_BLOCKS blocks.
Inode *read_inode_table(Superblock *sb) {
    Inode *inode_table = malloc(INODE_TABLE_BLOCKS * BLOCK_SIZE);
    if (!inode_table) {
        perror("malloc failed");
        exit(1);
    }
    for (int i = 0; i < INODE_TABLE_BLOCKS; i++) {
        read_block(INODE_TABLE_START + i, (uint8_t *)inode_table + i * BLOCK_SIZE);
    }
    return inode_table;
}

// For each data block referenced (direct or indirect), mark it in the 'referenced' array.
// Build a reference map of all data blocks referenced by valid inodes.
void build_reference_map(Superblock *sb, bool referenced[]) {
    Inode *inode_table = read_inode_table(sb);
    int inode_count = (sb->inode_count > MAX_INODES) ? MAX_INODES : sb->inode_count;
    for (int i = 0; i < inode_count; i++) {
        Inode *inode = &inode_table[i];
        if (inode->mode != 0) {  // inode in use
            // Process direct block pointers.
            for (int j = 0; j < 12; j++) {
                uint32_t b = inode->direct[j];
                if (b != 0 && b >= FIRST_DATA_BLOCK && b < TOTAL_BLOCKS)
                    referenced[b] = true;
            }
            // Process single indirect.
            if (inode->indirect != 0)
                process_indirect(inode->indirect, 1, referenced);
            // Process double indirect.
            if (inode->double_indirect != 0)
                process_indirect(inode->double_indirect, 2, referenced);
            // Process triple indirect.
            if (inode->triple_indirect != 0)
                process_indirect(inode->triple_indirect, 3, referenced);
        }
    }
    free(inode_table);
}

// Helper: Check if a block's bit is set in the data bitmap.
bool is_bit_set(uint8_t *bitmap, uint32_t block) {
    return (bitmap[block / 8] & (1 << (block % 8))) != 0;
}

// (a) For every block marked used in the data bitmap, verify it is referenced by some inode.
void check_data_bitmap_used_blocks(Superblock *sb, uint8_t *data_bitmap) {
    bool referenced[TOTAL_BLOCKS] = { 0 };
    build_reference_map(sb, referenced);
    for (int b = FIRST_DATA_BLOCK; b < TOTAL_BLOCKS; b++) {
        if (is_bit_set(data_bitmap, b) && !referenced[b])
            printf("Error: Data block %d is marked used in bitmap but not referenced by any inode.\n", b);          
    }
}

// (b) For every block referenced by an inode, verify it is marked used in the data bitmap.
void check_data_blocks_in_inodes(Superblock *sb, uint8_t *data_bitmap) {
    bool referenced[TOTAL_BLOCKS] = { 0 };
    build_reference_map(sb, referenced);
    for (int b = FIRST_DATA_BLOCK; b < TOTAL_BLOCKS; b++) {
        if (referenced[b] && !is_bit_set(data_bitmap, b))
            printf("Error: Data block %d is referenced by an inode but not marked used in the bitmap.\n", b);
    }
}

void check_inode_bitmap_consistency(Superblock *sb, uint8_t *inode_bitmap) {
    Inode *inode_table = read_inode_table(sb);
    int inode_count = (sb->inode_count > MAX_INODES) ? MAX_INODES : sb->inode_count;
    for (int i = 0; i < inode_count; i++) {
        bool bit_set = is_bit_set(inode_bitmap, i);
        bool valid_inode = (inode_table[i].links > 0 && inode_table[i].dtime == 0);
        if (bit_set && !valid_inode) {
            printf("Error: Inode %d is marked used in the inode bitmap but is not valid (links=%u, dtime=%u).\n",
                   i, inode_table[i].links, inode_table[i].dtime);
        }
        if (valid_inode && !bit_set) {
            printf("Error: Inode %d is valid but not marked as used in the inode bitmap.\n", i);
        }
    }
    free(inode_table);
}

// Process indirect pointers recursively (for duplicate checking).
// 'level' is 1 for single, 2 for double, etc.
// 'count' is an array tracking number of references for each block.
void process_indirect_duplicates(uint32_t block_num, int level, int count[]) {
    if (block_num < FIRST_DATA_BLOCK || block_num >= TOTAL_BLOCKS)
        return;
    uint32_t *block_ptrs = malloc(BLOCK_SIZE);
    if (!block_ptrs) {
        perror("malloc failed");
        exit(1);
    }
    read_block(block_num, block_ptrs);
    
    int pointers = BLOCK_SIZE / sizeof(uint32_t);
    for (int i = 0; i < pointers; i++) {
        uint32_t ptr = block_ptrs[i];
        if (ptr == 0)
            continue;
        if (level == 1) {
            if (ptr >= FIRST_DATA_BLOCK && ptr < TOTAL_BLOCKS)
                count[ptr]++;
        } else {
            process_indirect_duplicates(ptr, level - 1, count);
        }
    }
    free(block_ptrs);
}

// Duplicate Checker: Builds a count of how many times each data block
// is referenced by a valid inode; then prints an error for blocks that occur > 1.
void check_duplicate_blocks(Superblock *sb) {
    // Create an array to count references for each block.
    int count[TOTAL_BLOCKS] = {0};
    
    Inode *inode_table = read_inode_table(sb);
    int inode_count = (sb->inode_count > MAX_INODES) ? MAX_INODES : sb->inode_count;
    for (int i = 0; i < inode_count; i++) {
        Inode *inode = &inode_table[i];
        if (inode->mode != 0) {  // Inode in use.
            // Count direct pointers.
            for (int j = 0; j < 12; j++) {
                uint32_t b = inode->direct[j];
                if (b != 0 && b >= FIRST_DATA_BLOCK && b < TOTAL_BLOCKS)
                    count[b]++;
            }
            // Count single indirect pointers.
            if (inode->indirect != 0)
                process_indirect_duplicates(inode->indirect, 1, count);
            // Count double indirect pointers.
            if (inode->double_indirect != 0)
                process_indirect_duplicates(inode->double_indirect, 2, count);
            // Count triple indirect pointers.
            if (inode->triple_indirect != 0)
                process_indirect_duplicates(inode->triple_indirect, 3, count);
        }
    }
    free(inode_table);
    
    // Check for duplicate references.
    for (int b = FIRST_DATA_BLOCK; b < TOTAL_BLOCKS; b++) {
        if (count[b] > 1)
            printf("Error: Data block %d is referenced %d times.\n", b, count[b]);
    }
}

// Helper function to check a single block pointer.
// inode_index: the inode we’re checking.
// pointer_desc: description of the pointer (e.g. "direct", "single indirect")
// b: the block pointer value.
void check_block_pointer(int inode_index, const char *pointer_desc, uint32_t b) {
    if (b != 0 && (b < FIRST_DATA_BLOCK || b >= TOTAL_BLOCKS)) {
        printf("Error: Inode %d has invalid %s pointer: %u (valid range: %d-%d)\n",
               inode_index, pointer_desc, b, FIRST_DATA_BLOCK, TOTAL_BLOCKS - 1);
    }
}

// Recursively checks block pointers in an indirect block.
// level: 1 for single indirect, 2 for double, 3 for triple indirect.
// inode_index: current inode being checked.
// pointer_desc: description for error messages.
void check_indirect_bad(uint32_t block_num, int level, int inode_index, const char *pointer_desc) {
    if (block_num == 0)
        return;
    // Check that the indirect block pointer itself is in valid range.
    if (block_num < FIRST_DATA_BLOCK || block_num >= TOTAL_BLOCKS) {
        printf("Error: Inode %d has invalid %s block pointer: %u (valid range: %d-%d)\n",
               inode_index, pointer_desc, block_num, FIRST_DATA_BLOCK, TOTAL_BLOCKS - 1);
        return;
    }
    
    uint32_t *block_ptrs = malloc(BLOCK_SIZE);
    if (!block_ptrs) {
        perror("malloc failed");
        exit(1);
    }
    read_block(block_num, block_ptrs);
    
    int pointers = BLOCK_SIZE / sizeof(uint32_t);
    for (int i = 0; i < pointers; i++) {
        uint32_t ptr = block_ptrs[i];
        if (ptr == 0)
            continue;
        if (level == 1) {
            // For single indirect, check each pointer.
            check_block_pointer(inode_index, pointer_desc, ptr);
        } else {
            // For double/triple indirect pointers, go one level deeper.
            check_indirect_bad(ptr, level - 1, inode_index, pointer_desc);
        }
    }
    
    free(block_ptrs);
}

// Bad Block Checker: iterate through each valid inode and verify that every block pointer
// (direct and indirect) is within the valid range.
void check_bad_blocks(Superblock *sb) {
    Inode *inode_table = read_inode_table(sb);
    int inode_count = (sb->inode_count > MAX_INODES) ? MAX_INODES : sb->inode_count;
    for (int i = 0; i < inode_count; i++) {
        Inode *inode = &inode_table[i];
        if (inode->mode == 0)
            continue;  // Skip unused inodes.
        // Check direct pointers.
        for (int j = 0; j < 12; j++) {
            check_block_pointer(i, "direct", inode->direct[j]);
        }
        // Check single indirect pointer.
        if (inode->indirect != 0)
            check_indirect_bad(inode->indirect, 1, i, "single indirect");
        // Check double indirect pointer.
        if (inode->double_indirect != 0)
            check_indirect_bad(inode->double_indirect, 2, i, "double indirect");
        // Check triple indirect pointer.
        if (inode->triple_indirect != 0)
            check_indirect_bad(inode->triple_indirect, 3, i, "triple indirect");
    }
    free(inode_table);
}

// Fix the data bitmap:
// a. If a block is referenced by an inode but its bit is not set, set it.
// b. If a block is not referenced but its bit is set, clear it.
void fix_data_bitmap(Superblock *sb, uint8_t *data_bitmap) {
    bool referenced[TOTAL_BLOCKS] = { 0 };
    build_reference_map(sb, referenced);
    for (int b = FIRST_DATA_BLOCK; b < TOTAL_BLOCKS; b++) {
        bool in_bitmap = is_bit_set(data_bitmap, b);
        bool in_inode  = referenced[b];
        if (in_inode && !in_bitmap) {
            data_bitmap[b / 8] |= (1 << (b % 8));
            printf("Fixed: Set bit for data block %d in data bitmap.\n", b);
        } else if (!in_inode && in_bitmap) {
            data_bitmap[b / 8] &= ~(1 << (b % 8));
            printf("Fixed: Cleared bit for data block %d in data bitmap.\n", b);
        }
    }
    write_block(DATA_BITMAP_BLOCK, data_bitmap);
}

// Fix the inode bitmap so that every valid inode is marked used and every invalid is cleared.
void fix_inode_bitmap(Superblock *sb, uint8_t *inode_bitmap) {
    Inode *inode_table = read_inode_table(sb);
    int inode_count = (sb->inode_count > MAX_INODES) ? MAX_INODES : sb->inode_count;
    for (int i = 0; i < inode_count; i++) {
        bool valid_inode = (inode_table[i].links > 0 && inode_table[i].dtime == 0);
        bool bit_set = is_bit_set(inode_bitmap, i);
        if (valid_inode && !bit_set) {
            inode_bitmap[i / 8] |= (1 << (i % 8));
            printf("Fixed: Set bit for inode %d in inode bitmap.\n", i);
        } else if (!valid_inode && bit_set) {
            inode_bitmap[i / 8] &= ~(1 << (i % 8));
            printf("Fixed: Cleared bit for inode %d in inode bitmap.\n", i);
        }
    }
    free(inode_table);
    write_block(INODE_BITMAP_BLOCK, inode_bitmap);
}


void fix_superblock(Superblock *sb) {
    sb->magic               = MAGIC_NUMBER;
    sb->block_size          = BLOCK_SIZE;
    sb->total_blocks        = TOTAL_BLOCKS;
    sb->inode_bitmap_block  = INODE_BITMAP_BLOCK;
    sb->data_bitmap_block   = DATA_BITMAP_BLOCK;
    sb->inode_table_start   = INODE_TABLE_START;
    sb->data_block_start    = FIRST_DATA_BLOCK;
    sb->inode_size          = INODE_SIZE;
    sb->inode_count         = MAX_INODES;  // or your actual inode_count
    write_block(SUPERBLOCK_BLOCK, sb);
    printf("Fixed: Superblock fields updated.\n");
}


int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Usage: %s vsfs.img\n", argv[0]);
        return 1;
    }

    img = fopen(argv[1], "rb+");
    if (!img) {
        perror("Error opening file system image");
        return 1;
    }
    
    Superblock sb;
    read_block(SUPERBLOCK_BLOCK, &sb);
    printf("Checking superblock...\n");
    if (validate_superblock(&sb)) {
        printf("Superblock is valid.\n");
    } else {
        printf("Superblock has errors.\n");
        fix_superblock(&sb);
    }
    
    uint8_t data_bitmap[BLOCK_SIZE];
    uint8_t inode_bitmap[BLOCK_SIZE];
    read_block(DATA_BITMAP_BLOCK, data_bitmap);
    read_block(INODE_BITMAP_BLOCK, inode_bitmap);
    
    check_data_bitmap_used_blocks(&sb, data_bitmap);
    check_data_blocks_in_inodes(&sb, data_bitmap);
    
    check_inode_bitmap_consistency(&sb, inode_bitmap);
    printf("Consistency Checks Completed Successfully.\n");
    
    check_duplicate_blocks(&sb);
    printf("Duplicate Blocks Check Completed.\n");
    
    check_bad_blocks(&sb);
    printf("Bad Block Checks Completed.\n");
    
    // If errors have been reported, fix the bitmaps.
    fix_data_bitmap(&sb, data_bitmap);
    fix_inode_bitmap(&sb, inode_bitmap);
    printf("Fixes Completed Successfully.\n");

    fclose(img);
    return 0;
}

