public class Task5 {
    public static int sumDist(Node head, Integer[] distArr) {
        // To Do
        int sum = 0;
        int size = 0;
        Node temp1 = head;
        while(temp1 != null){
            size++;
            temp1 = temp1.next;
        }
        for (int i = 0; i < distArr.length; i++) {
            int dist = distArr[i];
            Node temp = head;
            if(dist<0){
                continue;
            } else if(dist > size){
                continue;
            }
            for (int i1 = 0; i1 < dist; i1++) {
                temp = temp.next;
            }
            sum+=(int)temp.elem;
        }
        return sum; // Remove this line.
    }

    public static void main(String[] args) {
        System.out.println("=========Test Case 1=============");
        Node head1 = LinkedList.createList(new Integer[]{10, 16, -5, 9, 3, 4});
        Integer[] dist = new Integer[] {2, 0, 5, 2, 8};
        System.out.print("Given LinkedList: ");
        LinkedList.printLL(head1);
        System.out.print("Distance Array: ");
        Arr.print(dist);
        System.out.println("\nExpected Output: 4");
        int returnedValue = Task5.sumDist(head1, dist);
        System.out.println("Your Output: "+returnedValue); // This should print: Sum of Nodes: 4
    }
}
