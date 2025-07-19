package LinkedList;

public class Implementation {

//    public static class Node{
//        int data;
//        Node next;
//        public Node(int data) {
//            this.data = data;
//        }
//    }
//    public static class linkedList{
//        Node head = null;
//        Node tail = null;
//        int size = 0;
//        void insertAtEnd(int data) { //Time complexity O(1)
//            Node newNode = new Node(data);
//            if (head == null) {
//                head = newNode;
//            } else {
//                tail.next = newNode;
//            }
//            tail = newNode;
//            size++;
//        }
//        void insertAtHead(int data) { //Time complexity O(1)
//            Node newNode = new Node(data);
////            if (head == null) { //empty list
////                head = newNode;
////                tail = newNode;
//            if (head == null) { //same works
//                insertAtEnd(data);
//            } else { //non-empty list
//                newNode.next = head;
//                head = newNode;
//            }
//            size++;
//        }
//        void display() {
//            Node temp = head;
//            while (temp != null) {
//                System.out.print(temp.data + " ");
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//        int size() { //Time complexity O(n)
////            int size = 0;
////            Node temp = head;
////            while (temp != null) {
////                size++;
////                temp = temp.next;
////            }
//            return size;
//        }
//        void insertAt(int index, int data) { //Time complexity O(n) Space Complexity O(1)
//            Node x = new Node(data);
//            Node temp = head;
//            if (index == 0) {
//                insertAtHead(data);
//                return;
//            } else if(index == size()){
//                insertAtEnd(data);
//                return;
//            } else if (index<0 || index>size()) {
//                System.out.println("Index out of bounds");
//                return;
//            }
//            for (int i = 1; i < index; i++) {
//                temp = temp.next;
//            }
//            x.next = temp.next;
//            temp.next = x;
//            size++;
//        }
//        int getElementAt(int index) { //Time complexity O(n)
//            Node temp = head;
//            if (index<0) {
//                System.out.println("Index out of bounds");
//                return -1;
//            } else if (index > size()) {
//                System.out.println("Index out of bounds");
//                return -1;
//            }
//            for (int i = 0; i < index; i++) {
//                temp = temp.next;
//            }
//            return temp.data;
//        }
//        void deleteAt(int index) {
//            Node temp = head;
//            if (index<0) {
//                System.out.println("Index out of bounds");
//            } else if (index==0) {
//                head = head.next;
//                size--;
//            } else {
//                for (int i = 1; i < index; i++) {
//                    temp = temp.next;
//                }
//                temp.next = temp.next.next;
//                tail = temp;
//                size--;
//            }
//        }
//    }
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
//        System.out.println(ll.size());
        ll.insertAtEnd(12);
        ll.insertAtHead(13);
//        ll.display();
        ll.insertAt(4,10);
//        ll.display();
//        System.out.println(ll.tail.data);
//        ll.insertAt(5,11);
//        ll.display();
//        System.out.println(ll.tail.data);
        ll.insertAt(0,100);
        ll.display();
        ll.deleteAt(5);
        ll.display();
        ll.deleteAt(0);
        ll.display();
        System.out.println(ll.getElementAt(3));
//        System.out.println(ll.getElementAt(4))
    }
}