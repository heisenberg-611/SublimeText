//DO NOT MODIFY ANY CODE IN THIS CLASS
public class Node {
    public Object elem;
    public Node next;

    public Node(Object elem, Node next){
        this.elem = elem;
        this.next = next;
    }

    //Overloading
    public Node(Object elem){
        this.elem = elem;
        this.next = null;
    }
}
