package LinkedList;

import javax.management.modelmbean.ModelMBean;

public class DLL {
    Node head;
    Node tail;
    int size = 0;

    public static Node InsertAtHead(Node head, int data) {
        Node t = new Node(data);
        t.next = head;
        head.prev = t;
        head = t;
        return head;
    }

    public static void InsertAtTail(Node head, int data) {
        Node temp = head;
        //temp ko tail taak leeke jaate hae
        while(temp.next != null) {
            temp = temp.next;
        }
        Node t = new Node(data);
        temp.next = t;
        temp.prev = temp;
    }
}