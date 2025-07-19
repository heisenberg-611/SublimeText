package Stack;

import java.util.Stack;

public class ReverseStack {
    public static void reverse(Stack<Integer> st){
        if (st.size()==1){
            return;
        }
        int top = st.pop();
        reverse(st);
        pushAtBottom.pushAtBottomRec(st, top);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
//        Stack <Integer> rt = new Stack<>();
//        while(!stack.isEmpty()){
//            rt.push(stack.pop());
//        }
//        System.out.println(rt);
//        Stack <Integer> rt2 = new Stack<>();
//        while (!rt.isEmpty()){
//            rt2.push(rt.pop());
//        }
//        System.out.println(rt2);
//        while(!rt2.isEmpty()){
//            stack.push(rt2.pop());
//        }
//        System.out.println(stack);
    }
}
