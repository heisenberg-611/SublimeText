#include <stdio.h>
#include <string.h>

#define MAX_ITEMS 50
#define MAX_ORDER 60

struct menuitem
{
    char name[20];
    float price[10];
};
struct order
{

    char customername[30];
    struct menuitem items[MAX_ITEMS];
    int quantity[MAX_ITEMS];
    int numitems;
};

void additem(struct menuitem menu[], int *numMenuitem)
{

    if (*numMenuitem < MAX_ITEMS)
    {

        printf(" Enter the items name=");
        scanf("%s", menu[*numMenuitem].name);
        printf(" Enter the price=");
        scanf("%f", &menu[*numMenuitem].price);
        (*numMenuitem)++;
    }
    else
    {

        printf(" menu is full");
    }
}
void displaymenu(struct menuitem menu[], int numMenuitem)
{
    printf(" ---- MENU----\n");

    for (int i = 0; i < numMenuitem; i++)
    {
        printf(" %d. %s= %f", i + 1, menu[i].name, menu[i].price);
    }
}

void addorder(struct menuitem menu[], struct order orders[], int *numorders, int numMenuitem)
{

    if (*numorders < MAX_ORDER)
    {

        struct order neworder;
        printf("Enter the customer name=");
        gets(neworder.customername);
        puts(neworder.customername);
        printf("ENter number of items=");
        scanf("%d", &neworder.numitems);
        printf(" ENter items");

        for (int i = 0; i < neworder.numitems; i++)
        {

            printf(" Item %d", i + 1);
            printf("Enter the name of item= ");
            scanf("%s", neworder.items[i].name);
            printf(" Enter the quantity=");
            scanf("%d", &neworder.quantity);

            for (int j = 0; j < numMenuitem; j++)
            {

                if (strcmp(neworder.items[i].name, menu[j].name) == 0)
                {
                    neworder.items[i].price = menu[j].price;
                    break;
                }
            }
        }

        orders[*numorders] = neworder;
        (*numorders)++;
        saveordertofile(&neworder);

        printf(" Order added successfully");
    }
    else
    {
        printf(" max order recahed");
    }
}

void displayorder(struct order orders)
{
    printf(" customer = %s\n", orders.customername);
    printf(" Item==");
    for (int i = 0; i < orders.numitems; i++)
    {

        printf("%s x %d -- %.2f", orders.items[i].name, orders.quantity, orders.items[i].price);
    }
    printf(" total price= %.2f", calculateTotal(orders));
}

void displayAllOrders(struct order orders[], int numorders)
{

    if (numorders == 0)
    {
        printf(" No order found");
    }
    else
    {
        printf(" All orders=\n");

        for (int i = 0; i < numorders; i++)
        {

            printf(" order %d", i + 1);
            displayorder(orders[i]);
        }
    }
}

float calculateTotal(struct order orders[], int numitems)
{
    float total = 0;

    for (int i = 0; i < numitems; i++)
    {

        total += orders[i].quantity * orders.items[i].price;
    }

    return total;
}
int searchorder(struct order orders[], int *numorders, char customername[30])
{

    for (int i = 0; i < numorders; i++)
    {

        if (strcmp(orders[i].customername, customername) == 0)
        {

            return i;
        }
    }

    return -1;
}
void deleteorder(struct order orders[], int *numorders, char customername[])
{

    int index = searchorder(orders, *numorders, customername);
    if (index != -1)
    {

        for (int i = 0; i < *numorders - 1; i++)
        {

            orders[i] = orders[i + 1];
        }
        (*numorders)--;
        printf(" order for %s deleted successfully", customername);
    }
    else
    {
        printf(" Order not found");
    }
}

void saveordertofile(struct order orders[])
{

    FILE *file;
    file = fopen("orders.txt", "a");

    if (file != NULL)
    {

        fprintf(file, "%s\n", orders.customername);
        fprintf(file, " Items=\n");

        for (int i = 0; i < orders.numitems; i++)
        {

            fprintf(file, "%s x%d - %.2f", orders.items[i].name, orders[i].quantity, orders.items[i].price);
        }

        fprintf(file, " total= .2%f", calculateTotal(orders));
        fprintf(file, "\n");
        fclose(file);
    }
    else
    {
        printf(" EORROR opening file");
    }
}

int main()
{

    struct menuitem menu[MAX_ITEMS];
    struct order orders[MAX_ORDER];
    int numorders;
    int numMenuitem;
    int choice;

    do
    {

        printf("\n\n Restaurant Billing System  \n");
        printf(" \n 1.Add item to menu \n");
        printf(" \n 2. Display menu\n");
        printf(" \n 3. ADD order\n");
        printf(" \n 4. Display all orders\n");
        printf("\n 5. Search order\n ");
        printf(" \n 6. Delete order\n");
        printf(" 7.Exit\n");

        printf("\n");

        printf(" Enter your choice =");
        scanf("  %d", &choice);

        switch (choice)
        {

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
        case 5:
            char customername[30];
            printf(" Enter that customer name that you want to search=");
            gets(customername);

            int index = searchorder(orders, numorders, customername);
            if (index != -1)
            {
                printf(" !!Order found!!");
                displayorder(orders[index]);
            }
            else
            {
                printf(" Order not found");
            }
            break;

        case 6:
            char deletename[20];
            printf(" Enter that customername you wanna delete=");
            gets(customername);

            deleteorder(orders, &numorders, deletename);
            break;

        case 7:
            printf(" bye bye!");
            break;
        default:
            printf(" Invalid choice");
        }
    } while (choice != 7);

    return 0;
}