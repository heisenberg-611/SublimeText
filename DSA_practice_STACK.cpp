#include <iostream>  // Header for input/output operations
using namespace std;  // Avoids writing std:: before standard library elements

#define nl endl  // Define a shorthand for newline character

// Define the maximum size of the stack
#define STACK_MAX 100

// Structure to represent a stack
typedef struct {
  int top;           // Index of the top element in the data array
  int data[STACK_MAX]; // Array to store stack elements
} Stack;

// Function to push an element onto the stack
void push(Stack *s, int item) {
  // Check if the stack is not full
  if (s->top < STACK_MAX) {
    // Add the item to the top of the stack
    s->data[s->top] = item;
    // Increment the top pointer to point to the newly added element
    s->top++;
  } else {
    // Print an error message if the stack is full
    cout << "Stack is full!" << nl;
  }
}

// Function to pop an element from the stack
int pop(Stack *s) {
  int item;

  // Check if the stack is not empty
  if (s->top == 0) {
    // Print an error message if the stack is empty
    cout << "Stack is empty" << nl;
    // Return a special value (e.g., -1) to indicate an error
    return -1;
  } else {
    // Decrement the top pointer to point to the previous element
    s->top--;
    // Get the item to be popped
    item = s->data[s->top];
  }
  // Return the popped element
  return item;
}

int main() {
  // Create a stack instance
  Stack s;

  // Initialize the top pointer to 0 (common practice for clarity)
  s.top = 0;

  // Example usage of push and pop
  push(&s, 10);
  push(&s, 20);
  push(&s, 30);

  cout << pop(&s) << nl;  // Output: 30
  cout << pop(&s) << endl; // Output: 20
  cout << pop(&s) << endl; // Output: 10
  cout << pop(&s) << endl; // Output: Stack is empty
  return 0;
}
