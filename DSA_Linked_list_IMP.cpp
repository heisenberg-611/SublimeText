#include <iostream>  // Header for input/output operations
#include <cstdlib>  // Header for memory allocation (malloc)

using namespace std;

// Structure to represent a node in a linked list
struct Node {
  int data;  // Integer data stored in the node
  Node *next; // Pointer to the next node in the linked list (initially null)
};

// Function to create a new node with the given data and set its next pointer
Node *create_node(int item, Node *next) {
  // Allocate memory for a new node using malloc
  Node *new_node = (Node *)malloc(sizeof(Node));

  // Check if memory allocation was successful
  if (new_node == NULL) {
    cout << "Error, could not create a new node!!!" << endl;
    exit(1);  // Exit the program with an error code
  }

  // Assign the data value to the new node
  new_node->data = item;

  // Set the next pointer of the new node
  new_node->next = next;

  // Return the pointer to the newly created node
  return new_node;
}

int main() {
  // Create the head node with data value 10 and next set to null
  Node *head = create_node(10, NULL);

  // Create two more nodes with data values 20 and 30
  Node *second = create_node(20, NULL);
  Node *third = create_node(30, NULL);

  // Link the nodes together: head -> second -> third -> NULL
  head->next = third;
  third->next = second;

  // Print the data stored in each node by traversing the linked list
  Node *current = head;
  while (current != NULL) {
    cout << current->data << " -> ";
    current = current->next;
  }
  cout << "NULL" << endl;

  return 0;  // Indicate successful program termination
}