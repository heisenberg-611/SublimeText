package Stack;

import java.util.Stack;

public class moveStackInSameOrder {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
//        int n;
//        System.out.println("Enter no of elements in the stack");
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        System.out.println("Enter elements in the stack");
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            stack.push(x);
//        }
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        //Reverse Order
        Stack<Integer> rt = new Stack<>();
        while(!stack.isEmpty()){
//            int x = stack.peek();
//            rt.push(x);
//            stack.pop();
            rt.push(stack.pop());
        }
        System.out.println(rt);
        Stack<Integer> copy = new Stack<>();
        while(!rt.isEmpty()){
            copy.push(rt.pop());
        }
        System.out.println(copy);
    }
}
