package LinkedList;

public class nthNodeFromEnd {
    public static Node nthNodeNormal(Node head, int n) {
        int size = 0;
        Node temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        int m = size - n + 1;
        temp = head;
        for(int i = 1; i < m; i++){
            temp = temp.next;
        }
        return temp;
    }

    //In one traversal
    public static Node nthNodeInOneTraversal(Node head, int n) {
        Node slow = head;
        Node fast = head;
        for(int i = 1; i <= n; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static Node nthNodeDeleteFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;
        for(int i = 1; i <= n; i++){
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
            return head;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node a = new Node(100);
        Node b = new Node(13);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(12);
        Node f = new Node(10);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        // 100 13 4 5 12 18
        Node temp1 = nthNodeInOneTraversal(a, 2);
        display(temp1);
//        Node temp2 = nthNodeInOneTraversal(a,2);
//        System.out.println(temp2.data);
//        display(a);
//        a = nthNodeDeleteFromEnd(a, 6);
//        display(a);
//    }
}}