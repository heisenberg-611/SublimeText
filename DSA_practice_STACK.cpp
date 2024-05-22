#include <iostream>

using namespace std;

#define nl endl  // For cleaner newline characters

#define STACK_MAX 100

// Structure to represent a stack
struct Stack {
    int top;      // Index of the top element in the stack
    int data[STACK_MAX]; // Array to store stack elements
};

// Function to check if the stack is full
bool isFull(Stack *s) {
    return s->top == STACK_MAX - 1;
}

// Function to check if the stack is empty
bool isEmpty(Stack *s) {
    return s->top == -1;
}

// Function to push (insert) an element onto the stack
void push(Stack *s, int item) {
    if (isFull(s)) {
        cout << "Stack is full!" << nl;
        return;
    }
    s->data[++s->top] = item;  // Pre-increment for efficiency
}

// Function to pop (remove) an element from the stack
int pop(Stack *s) {
    if (isEmpty(s)) {
        cout << "Stack is empty" << nl;
        return -1; // Indicate error or special value for empty stack
    }
    return s->data[s->top--];  // Post-decrement for efficiency
}

int main() {
    Stack s;  // Create a stack instance

    // Initialize the top pointer (common practice for clarity)
    s.top = -1;

    // Example usage of push and pop
    push(&s, 10);
    push(&s, 20);
    push(&s, 30);

    cout << pop(&s) << " ";  // Output: 30
    cout << pop(&s) << endl;  // Output: 20

    return 0;
}
