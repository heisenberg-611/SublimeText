package Stack;


public class arrayImplementation {
    public static class Stack{
        private int[] arr = new int[5];
        private int idx = 0;
        void push(int data){
            if(idx == arr.length){
                System.out.println("Stack is full");
                return;
            }
            arr[idx] = data;
            idx++;
        }
        int peek(){
            if(idx == 0){
                System.out.println("Stack is empty");
                return -1;
            }
            return arr[idx-1];
        }
        int pop(){
            if(idx == 0){
                System.out.println("Stack is empty");
                return -1;
            }
            int top = arr[idx-1];
            arr[idx-1] = 0;
            idx--;
            return top;
        }
        void display(){
            for(int i = 0 ; i < idx ; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        int size(){
            return idx;
        }
        boolean isEmpty(){
            if(idx == 0){
                return true;
            } else {
                return false;
            }
        }
        boolean isFull(){
            if(idx == arr.length){
                return true;
            } else {
                return false;
            }
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.display();
        st.pop();
        st.display();
        st.pop();
        st.display();
        st.push(6);
        st.push(7);
        st.isFull();
        st.display();
        st.push(8);
        st.push(9);
    }
}
