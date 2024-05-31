#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Maximum constants
#define max_users 100
#define max_name 40
#define max_password 20
#define max_items 100

// Structures
typedef struct signup {
    char username[max_name];
    char password[max_password];
    char email[max_name];
} user;

typedef struct adding_product {
    int quantity;
    char name[max_name];
    float price;
} item;

typedef struct order_details {
    char item_name[max_name];
    int item_count;
    float total_price;
} order;

// Function declarations
void signup();
int signin();
void add_items();
void view_items();
void delete_item();
void search_item();
void add_cart();
void checkout();
void view_orders();
void save_users();
void load_users();
void save_items();
void load_items();
void view_profile();
void signout();

// Global variables
user users[max_users];
item items[max_items];
order orders[max_items];
int user_count = 0;
int item_count = 0;
int order_count = 0;
user* current_user = NULL;

int main() {
    load_users();
    load_items();
    int logged_in = 0;
    int choice;

    while (1) {
        printf("Welcome to the Online Sporting Goods Shop\n");
        printf("1. Sign Up\n2. Sign In\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        getchar();

        switch (choice) {
            case 1:
                signup();
                break;
            case 2:
                logged_in = signin();
                if (logged_in) {
                    current_user = &users[logged_in - 1];
                    int choice1;
                    while (logged_in) {
                        printf("1. Add Item\n2. View items\n3. Delete Item\n4. Search Item\n5. Add to cart\n6. Checkout\n7. View Orders\n8. View profile\n9. Logout\n");
                        printf("Enter your choice: ");
                        scanf("%d", &choice1);
                        getchar();

                        switch (choice1) {
                            case 1:
                                add_items();
                                break;
                            case 2:
                                view_items();
                                break;
                            case 3:
                                delete_item();
                                break;
                            case 4:
                                search_item();
                                break;
                            case 5:
                                add_cart();
                                break;
                            case 6:
                                checkout();
                                break;
                            case 7:
                                view_orders();
                                break;
                            case 8:
                                view_profile();
                                break;
                            case 9:
                                signout();
                                logged_in = 0;
                                break;
                            default:
                                printf("Invalid choice!\n");
                        }
                    }
                }
                break;
            default:
                printf("Invalid choice!\n");
        }
    }

    return 0;
}

// Function definitions
void signup() {
    if (user_count >= max_users) {
        printf("User limit exceeded!\n");
        return;
    }

    user new_user;
    printf("Enter username: ");
    fgets(new_user.username, sizeof(new_user.username), stdin);
    new_user.username[strcspn(new_user.username, "\n")] = '\0';  // Remove newline character
    printf("Enter password: ");
    fgets(new_user.password, sizeof(new_user.password), stdin);
    new_user.password[strcspn(new_user.password, "\n")] = '\0';  // Remove newline character
    printf("Enter email: ");
    fgets(new_user.email, sizeof(new_user.email), stdin);
    new_user.email[strcspn(new_user.email, "\n")] = '\0';  // Remove newline character

    users[user_count++] = new_user;
    printf("User signed up successfully!\n");
}

int signin() {
    char username[max_name];
    char password[max_password];

    printf("Enter username: ");
    fgets(username, sizeof(username), stdin);
    username[strcspn(username, "\n")] = '\0';  // Remove newline character
    printf("Enter password: ");
    fgets(password, sizeof(password), stdin);
    password[strcspn(password, "\n")] = '\0';  // Remove newline character

    for (int i = 0; i < user_count; i++) {
        if (strcmp(users[i].username, username) == 0 && strcmp(users[i].password, password) == 0) {
            printf("Signed in successfully! Welcome, %s.\n", users[i].username);
            return i + 1;
        }
    }

    printf("Invalid username or password. Please try again.\n");
    return 0;
}

void add_items() {
    if (item_count >= max_items) {
        printf("Item limit exceeded. Please try deleting an item.\n");
        return;
    }

    item new_item;
    printf("Enter item name: ");
    fgets(new_item.name, sizeof(new_item.name), stdin);
    new_item.name[strcspn(new_item.name, "\n")] = '\0';  // Remove newline character
    printf("Enter item price: ");
    scanf("%f", &new_item.price);
    printf("Enter item quantity: ");
    scanf("%d", &new_item.quantity);
    getchar();  // Consume newline character

    items[item_count++] = new_item;
    printf("Item added successfully!\n");
}

void view_items() {
    if (item_count == 0) {
        printf("No items available in the shop.\n");
        return;
    }

    for (int i = 0; i < item_count; i++) {
        printf("No: %d. Name: %s, Price: %.2f, Quantity: %d\n", i + 1, items[i].name, items[i].price, items[i].quantity);
    }
}

void delete_item() {
    char item_name[max_name];
    printf("Enter the name of the item to delete: ");
    fgets(item_name, sizeof(item_name), stdin);
    item_name[strcspn(item_name, "\n")] = '\0';  // Remove newline character

    for (int i = 0; i < item_count; i++) {
        if (strcmp(items[i].name, item_name) == 0) {
            for (int j = i; j < item_count - 1; j++) {
                items[j] = items[j + 1];
            }
            item_count--;
            printf("Item deleted successfully!\n");
            return;
        }
    }

    printf("Item not found!\n");
}

void search_item() {
    char item_name[max_name];
    printf("Enter name of the item to search: ");
    fgets(item_name, sizeof(item_name), stdin);
    item_name[strcspn(item_name, "\n")] = '\0';  // Remove newline character

    for (int i = 0; i < item_count; i++) {
        if (strcmp(items[i].name, item_name) == 0) {
            printf("Item found: %s.\nPrice: %.2f\nQuantity: %d\n", items[i].name, items[i].price, items[i].quantity);
            return;
        }
    }

    printf("Item not found!\n");
}

void add_cart() {
    if (order_count >= max_items) {
        printf("Order limit exceeded!\n");
        return;
    }

    char item_name[max_name];
    int quantity;
    printf("Enter the name of the item to order: ");
    fgets(item_name, sizeof(item_name), stdin);
    item_name[strcspn(item_name, "\n")] = '\0';  // Remove newline character
    printf("Enter quantity: ");
    scanf("%d", &quantity);
    getchar();  // Consume newline character

    for (int i = 0; i < item_count; i++) {
        if (strcmp(items[i].name, item_name) == 0) {
            if (items[i].quantity >= quantity) {
                order new_order;
                strcpy(new_order.item_name, items[i].name);
                new_order.item_count = quantity;
                new_order.total_price = items[i].price * quantity;

                orders[order_count++] = new_order;
                items[i].quantity -= quantity;
                printf("Item added to cart successfully!\n");
                return;
            } else {
                printf("Insufficient quantity available!\n");
                return;
            }
        }
    }

    printf("Item not found!\n");
}

void checkout() {
    float total_amount = 0;
    printf("Order details:\n");

    for (int i = 0; i < order_count; i++) {
        printf("Item: %s, Quantity: %d, Total price: %.2f\n", orders[i].item_name, orders[i].item_count, orders[i].total_price);
        total_amount += orders[i].total_price;
    }

    printf("Total amount: %.2f\n", total_amount);
}

void view_orders() {
    if (order_count == 0) {
        printf("No orders placed.\n");
        return;
    }

    printf("All orders:\n");
    printf("----------\n");

    for (int i = 0; i < order_count; i++) {
        printf("Item: %s, Quantity: %d, Total price: %.2f\n", orders[i].item_name, orders[i].item_count, orders[i].total_price);
    }
}

void save_users() {
    FILE *file = fopen("users.dat", "wb");
    fwrite(&user_count, sizeof(int), 1, file);
    fwrite(users, sizeof(user), user_count, file);
    fclose(file);
    printf("Users saved successfully!\n");
}

void load_users() {
    FILE *file = fopen("users.dat", "rb");
    if (file) {
        fread(&user_count, sizeof(int), 1, file);
        fread(users, sizeof(user), user_count, file);
        fclose(file);
        printf("Users loaded successfully!\n");
    }
}

void save_items() {
    FILE *file = fopen("items.dat", "wb");
    fwrite(&item_count, sizeof(int), 1, file);
    fwrite(items, sizeof(item), item_count, file);
    fclose(file);
    printf("Items saved successfully!\n");
}

void load_items() {
    FILE *file = fopen("items.dat", "rb");
    if (file) {
        fread(&item_count, sizeof(int), 1, file);
        fread(items, sizeof(item), item_count, file);
        fclose(file);
        printf("Items loaded successfully!\n");
    }
}

void view_profile() {
    if (current_user != NULL) {
        printf("Username: %s\n", current_user->username);
        printf("Email: %s\n", current_user->email);
    } else {
        printf("No user signed in.\n");
    }
}

void signout() {
    if (current_user != NULL) {
        current_user = NULL;
        printf("Signed out successfully.\n");
    } else {
        printf("No user signed in.\n");
    }
}
