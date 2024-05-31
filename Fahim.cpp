#include <stdio.h>
#include <string.h>

#define MAX_ITEMS 50
#define MAX_ORDERS 100

struct MenuItem {
    char name[50];
    float price;
};

struct Order {
    char customerName[50];
    struct MenuItem items[MAX_ITEMS];
    int quantity[MAX_ITEMS];
    int numItems;
};

void addItem(struct MenuItem menu[], int *numMenuItems);
void displayMenu(struct MenuItem menu[], int numMenuItems);
void addOrder(struct Order orders[], int *numOrders, struct MenuItem menu[], int numMenuItems);
void displayOrder(struct Order order);
void displayAllOrders(struct Order orders[], int numOrders);
int searchOrder(struct Order orders[], int numOrders, char customerName[]);
void deleteOrder(struct Order orders[], int *numOrders, char customerName[]);
float calculateTotal(struct Order order);
void saveOrderToFile(struct Order order);
void loadOrdersFromFile(struct Order orders[], int *numOrders);

int main() {
    struct MenuItem menu[MAX_ITEMS];
    struct Order orders[MAX_ORDERS];
    int numMenuItems = 0;
    int numOrders = 0;
    int choice;

    loadOrdersFromFile(orders, &numOrders); // Load orders from file

    do {
        printf("\n\nRestaurant Billing System\n");
        printf("1. Add Item to Menu\n");
        printf("2. Display Menu\n");
        printf("3. Add Order\n");
        printf("4. Display All Orders\n");
        printf("5. Search Order\n");
        printf("6. Delete Order\n");
        printf("7. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {
            case 1:
                addItem(menu, &numMenuItems);
                break;
            case 2:
                displayMenu(menu, numMenuItems);
                break;
            case 3:
                addOrder(orders, &numOrders, menu, numMenuItems);
                break;
            case 4:
                displayAllOrders(orders, numOrders);
                break;
            case 5: {
                char searchName[50];
                printf("Enter customer name to search: ");
                scanf("%s", searchName);
                int index = searchOrder(orders, numOrders, searchName);
                if (index != -1) {
                    printf("Order found:\n");
                    displayOrder(orders[index]);
                } else {
                    printf("Order not found.\n");
                }
                break;
            }
            case 6: {
                char deleteName[50];
                printf("Enter customer name to delete: ");
                scanf("%s", deleteName);
                deleteOrder(orders, &numOrders, deleteName);
                break;
            }
            case 7:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 7); 

    return 0;
}

void addItem(struct MenuItem menu[], int *numMenuItems) {
    if (*numMenuItems < MAX_ITEMS) {
        printf("Enter item name: ");
        scanf("%s", menu[*numMenuItems].name);
        printf("Enter item price: ");
        scanf("%f", &menu[*numMenuItems].price);
        (*numMenuItems)++;
    } else {
        printf("Menu is full. Cannot add more items.\n");
    }
}

void displayMenu(struct MenuItem menu[], int numMenuItems) {
    printf("Menu:\n");
    for (int i = 0; i < numMenuItems; i++) {
        printf("%d. %s - %.2f\n", i + 1, menu[i].name, menu[i].price);
    }
}

void addOrder(struct Order orders[], int *numOrders, struct MenuItem menu[], int numMenuItems) {
    if (*numOrders < MAX_ORDERS) {
        struct Order newOrder;
        printf("Enter customer name: ");
        scanf("%s", newOrder.customerName);
        printf("Enter number of items: ");
        scanf("%d", &newOrder.numItems);
        printf("Enter items:\n");
        for (int i = 0; i < newOrder.numItems; i++) {
            printf("Item %d:\n", i + 1);
            printf("Name: ");
            scanf("%s", newOrder.items[i].name);
            printf("Quantity: ");
            scanf("%d", &newOrder.quantity[i]);
            // Look up price from menu
            for (int j = 0; j < numMenuItems; j++) {
                if (strcmp(newOrder.items[i].name, menu[j].name) == 0) {
                    newOrder.items[i].price = menu[j].price;
                    break;
                }
            }
        }
        orders[*numOrders] = newOrder;
        (*numOrders)++;
        saveOrderToFile(newOrder); // Save order to file
        printf("Order added successfully.\n");
    } else {
        printf("Maximum orders reached. Cannot add more orders.\n");
    }
}

void displayOrder(struct Order order) {
    printf("Customer: %s\n", order.customerName);
    printf("Items:\n");
    for (int i = 0; i < order.numItems; i++) {
        printf("%s x %d - %.2f\n", order.items[i].name, order.quantity[i], order.items[i].price);
    }
    printf("Total: %.2f\n", calculateTotal(order));
}

void displayAllOrders(struct Order orders[], int numOrders) {
    if (numOrders == 0) {
        printf("No orders found.\n");
    } else {
        printf("All Orders:\n");
        for (int i = 0; i < numOrders; i++) {
            printf("Order %d:\n", i + 1);
            displayOrder(orders[i]);
        }
    }
}

int searchOrder(struct Order orders[], int numOrders, char customerName[]) {
    for (int i = 0; i < numOrders; i++) {
        if (strcmp(orders[i].customerName, customerName) == 0) {
            return i; // Order found
        }
    }
    return -1; // Order not found
}

void deleteOrder(struct Order orders[], int *numOrders, char customerName[]) {
    int index = searchOrder(orders, *numOrders, customerName);
    if (index != -1) {
        for (int i = index; i < *numOrders - 1; i++) {
            orders[i] = orders[i + 1];
        }
        (*numOrders)--;
        printf("Order for %s deleted successfully.\n", customerName);
    } else {
        printf("Order not found.\n");
    }
}

float calculateTotal(struct Order order) {
    float total = 0;
    for (int i = 0; i < order.numItems; i++) {
        total += order.quantity[i] * order.items[i].price;
    }
    return total;
}

void saveOrderToFile(struct Order order) {
    FILE *file = fopen("orders.txt", "a");
    if (file != NULL) {
        fprintf(file, "Customer: %s\n", order.customerName);
        fprintf(file, "Items:\n");
        for (int i = 0; i < order.numItems; i++) {
            fprintf(file, "%s x %d - %.2f\n", order.items[i].name, order.quantity[i], order.items[i].price);
        }
        fprintf(file, "Total: %.2f\n", calculateTotal(order));
        fprintf(file, "\n");
        fclose(file);
    } else {
        printf("Error opening file.\n");
    }
}

void loadOrdersFromFile(struct Order orders[], int *numOrders) {
    FILE *file = fopen("orders.txt", "r");
    if (file != NULL) {
        while (!feof(file) && *numOrders < MAX_ORDERS) {
            struct Order order;
            fscanf(file, "Customer: %s\n", order.customerName);
            fscanf(file, "Items:\n");
            int i = 0;
            while (fscanf(file, "%s x %d - %f\n", order.items[i].name, &order.quantity[i], &order.items[i].price) == 3) {
                i++;
            }
            order.numItems = i;
            orders[*numOrders] = order;
            (*numOrders)++;
        }
        fclose(file);
    } else {
        printf("No order found in file.\n");
    }
}