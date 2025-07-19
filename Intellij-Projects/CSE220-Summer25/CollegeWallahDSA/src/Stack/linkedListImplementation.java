package Stack;

public class linkedListImplementation {

    public static class Node{ //User defined data type
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public static class LLStack{ //User defined data structure
        private Node head = null;
        private int size = 0;
        void push(int x){
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
            size++;
        }
        int pop(){
            if(head == null){
                System.out.println("Stack is empty");
                return -1;
            }
            else{
                int temp = head.data;
                head = head.next;
                size--;
                return temp;
            }
        }
        int peek(){
            if(head == null){
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }
        void displayRec(Node h){
            if(h == null){
                return;
            }
            displayRec(h.next);
            System.out.print(h.data+" ");
        }
        void display(){
            displayRec(head);
            System.out.println();
        }
        void displayRev(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
        int getSize(){
            return size;
        }
        boolean isEmpty(){
            return size == 0;
        }
    }

    public static void main(String[] args) {
        LLStack st = new LLStack();
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
        st.display();
        st.push(8);
        st.push(9);
        st.display();
    }
}
