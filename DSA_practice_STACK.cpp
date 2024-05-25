#include<iostream>
using namespace std;

#define nl endl

#define STACK_MAX 100

typedef struct{
	int top;
	int data [STACK_MAX];
} Stack;

void push(Stack *s, int item){
	if (s->top < STACK_MAX){
		s->data[s->top] = item;
		s->top = s->top + 1;
	} else {
		cout<<"Stack is full!"<<nl;
	}
}

int pop(Stack *s){
	int item;
	
	if(s->top == 0){
		cout<<"Stack is empty"<<nl;
		return -1;
	}else{
		s->top = s->top - 1;
		item = s->data[s->top];
	}
	return item;
}

int main() {
    Stack s;  // Create a stack instance

    // Initialize the top pointer (common practice for clarity)
    s.top = 0;

    // Example usage of push and pop
    push(&s, 10);
    push(&s, 20);
    push(&s, 30);

    cout << pop(&s) << nl;  // Output: 30
    cout << pop(&s) << endl;  // Output: 20
    cout << pop(&s) << endl;
    cout << pop(&s) << endl;
    return 0;
}