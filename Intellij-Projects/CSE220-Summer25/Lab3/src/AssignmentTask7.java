public class AssignmentTask7 {

    //SUBMIT ONLY THIS METHOD
    public static void rangeMove(DNode dh, int start, int end) {
    if (dh == null || dh.next == dh) {
        return;
    }
    
    DNode c = dh.next;
    DNode l = dh.prev;
    DNode t = l;
    
    while (c != l) {
        DNode n = c.next;
        int v = (int)c.elem;
        
        if (v >= start && v <= end) {
            c.prev.next = c.next;
            c.next.prev = c.prev;
            t.next = c;
            c.prev = t;
            c.next = dh;
            dh.prev = c;
            t = c;
        }
        c = n;
    }
    int lastVal = (int)l.elem;
    if (lastVal >= start && lastVal <= end) {
        l.prev.next = dh;
        dh.prev = l.prev;
        t.next = l;
        l.prev = t;
        l.next = dh;
        dh.prev = l;
    }
}

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] values = {5, 3, 7, 1, 9, 6, 2, 4};
        DNode dh = LinkedListHelpers.createDummyHeadedDoublyLL(values, true);

        System.out.println("Given Linked List:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);

        System.out.println("\nExpected Output:");
        Object[] expected = {3, 1, 9, 2, 4, 5, 7, 6};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);
        
        //Running the Range Move with [5,7] range 
        rangeMove(dh, 5, 7);
        //Printing after Range Move
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);
    }
}
