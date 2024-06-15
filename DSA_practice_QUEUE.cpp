#include <iostream>
using namespace std;

#define Q_SIZE 5  // Maximum capacity of the queue

// Structure to represent a queue
typedef struct {
    int data[Q_SIZE + 1]; // Array to store queue elements
    int head, tail;       // Indices for front and rear of the queue
}Queue;

// Function to check if the queue is full
bool isFull(Queue *q) {
    return (q->tail + 1) % (Q_SIZE + 1) == q->head;
}

// Function to check if the queue is empty
bool isEmpty(Queue *q) {
    return q->tail == q->head;
}

// Function to enqueue (insert) an element into the queue
void enqueue(Queue *q, int item) {
    if (isFull(q)) {
        std::cout << "Queue is full" << std::endl;
        return;
    }
    q->data[q->tail] = item;
    q->tail = (q->tail + 1) % (Q_SIZE + 1);
}

// Function to dequeue (remove) an element from the queue
int dequeue(Queue *q) {
    if (isEmpty(q)) {
        std::cout << "Queue is empty" << std::endl;
        return -1; // Indicate error or special value for empty queue
    }
    int item = q->data[q->head];
    q->head = (q->head + 1) % (Q_SIZE + 1);
    return item;
}

int main() {
    Queue q;  // Create a queue instance
    int item;
    // Initialize head and tail pointers (common practice for clarity)
    q.head = q.tail = 0;

    // Example usage of enqueue and dequeue
    enqueue(&q, 5);
    cout<<"tail"<<q.tail<<endl;
    enqueue(&q, 20);
    cout<<"tail"<<q.tail<<endl;
    enqueue(&q, 30);
    cout<<"tail"<<q.tail<<endl;
    
    cout<<"head"<<q.head<<endl;
    
    std::cout << dequeue(&q) << " " ; // Output: 10
    std::cout << dequeue(&q) << " " ; // Output: 20
    std::cout << dequeue(&q) << std::endl;
    cout<<dequeue(&q)<<endl;

    return 0;
}