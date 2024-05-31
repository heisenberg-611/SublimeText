#include <stdio.h>
#include <string.h>

#define MAX_ITEMS 50
#define MAX_ORDER 60

struct menuitem {
    char name[20];
    float price;
};

struct order {
    char customername[30];
    struct menuitem items[MAX_ITEMS];
    int quantity[MAX_ITEMS];
    int numitems;
};


float calculateTotal(struct order *order);


void additem(struct menuitem menu[], int *numMenuitem) {
    if (*numMenuitem < MAX_ITEMS) {
        printf("Enter the item's name: ");
        scanf("%s", menu[*numMenuitem].name);
        printf("Enter the price: ");
        scanf("%f", &menu[*numMenuitem].price);
        (*numMenuitem)++;
    } else {
        printf("Menu is full\n");
    }
}

void displaymenu(struct menuitem menu[], int numMenuitem) {
    printf("---- MENU ----\n");
    for (int i = 0; i < numMenuitem; i++) {
        printf("%d. %s = %.2f\n", i + 1, menu[i].name, menu[i].price);
    }
}

void saveordertofile(struct order *neworder) {
    FILE *file = fopen("orders.txt", "a");
    if (file != NULL) {
        fprintf(file, "Customer: %s\n", neworder->customername);
        fprintf(file, "Items:\n");
        for (int i = 0; i < neworder->numitems; i++) {
            fprintf(file, "%s x%d - %.2f\n", neworder->items[i].name, neworder->quantity[i], neworder->items[i].price);
        }
        fprintf(file, "Total = %.2f\n", calculateTotal(neworder));
        fprintf(file, "\n");
        fclose(file);
    } else {
        printf("Error opening file\n");
    }
}

float calculateTotal(struct order *order) {
    float total = 0;
    for (int i = 0; i < order->numitems; i++) {
        total += order->quantity[i] * order->items[i].price;
    }
    return total;
}

void addorder(struct menuitem menu[], struct order orders[], int *numorders, int numMenuitem) {
    if (*numorders < MAX_ORDER) {
        struct order neworder;
        printf("Enter the customer's name: ");
        scanf("%s", neworder.customername);
        printf("Enter the number of items: ");
        scanf("%d", &neworder.numitems);
        for (int i = 0; i < neworder.numitems; i++) {
            printf("Item %d\n", i + 1);
            printf("Enter the name of the item: ");
            scanf("%s", neworder.items[i].name);
            printf("Enter the quantity: ");
            scanf("%d", &neworder.quantity[i]);

            int found = 0;
            for (int j = 0; j < numMenuitem; j++) {
                if (strcmp(neworder.items[i].name, menu[j].name) == 0) {
                    neworder.items[i].price = menu[j].price;
                    found = 1;
                    break;
                }
            }
            if (!found) {
                printf("Item not found in menu\n");
                i--; // redo this item
            }
        }

        orders[*numorders] = neworder;
        (*numorders)++;
        saveordertofile(&neworder);
        printf("Order added successfully\n");
    } else {
        printf("Max order reached\n");
    }
}

void displayorder(struct order order) {
    printf("Customer: %s\n", order.customername);
    for (int i = 0; i < order.numitems; i++) {
        printf("%s x %d -- %.2f\n", order.items[i].name, order.quantity[i], order.items[i].price);
    }
    printf("Total price: %.2f\n", calculateTotal(&order));
}

void displayAllOrders(struct order orders[], int numorders) {
    if (numorders == 0) {
        printf("No orders found\n");
    } else {
        printf("All orders:\n");
        for (int i = 0; i < numorders; i++) {
            printf("Order %d\n", i + 1);
            displayorder(orders[i]);
        }
    }
}

int searchorder(struct order orders[], int numorders, char customername[30]) {
    for (int i = 0; i < numorders; i++) {
        if (strcmp(orders[i].customername, customername) == 0) {
            return i;
        }
    }
    return -1;
}

void deleteorder(struct order orders[], int *numorders, char customername[]) {
    int index = searchorder(orders, *numorders, customername);
    if (index != -1) {
        for (int i = index; i < *numorders - 1; i++) {
            orders[i] = orders[i + 1];
        }
        (*numorders)--;
        printf("Order for %s deleted successfully\n", customername);
    } else {
        printf("Order not found\n");
    }
}

int main() {
    struct menuitem menu[MAX_ITEMS];
    struct order orders[MAX_ORDER];
    int numorders = 0;
    int numMenuitem = 0;
    int choice;

    do {
        printf("\n\nRestaurant Billing System\n");
        printf("1. Add item to menu\n");
        printf("2. Display menu\n");
        printf("3. Add order\n");
        printf("4. Display all orders\n");
        printf("5. Search order\n");
        printf("6. Delete order\n");
        printf("7. Exit\n");

        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                additem(menu, &numMenuitem);
                break;
            case 2:
                displaymenu(menu, numMenuitem);
                break;
            case 3:
                addorder(menu, orders, &numorders, numMenuitem);
                break;
            case 4:
                displayAllOrders(orders, numorders);
                break;
            case 5: {
                char customername[30];
                printf("Enter the customer name to search: ");
                scanf("%s", customername);
                int index = searchorder(orders, numorders, customername);
                if (index != -1) {
                    printf("Order found!\n");
                    displayorder(orders[index]);
                } else {
                    printf("Order not found\n");
                }
                break;
            }
            case 6: {
                char customername[30];
                printf("Enter the customer name to delete: ");
                scanf("%s", customername);
                deleteorder(orders, &numorders, customername);
                break;
            }
            case 7:
                printf("Goodbye!\n");
                break;
            default:
                printf("Invalid choice\n");
        }
    } while (choice != 7);

    return 0;
}
