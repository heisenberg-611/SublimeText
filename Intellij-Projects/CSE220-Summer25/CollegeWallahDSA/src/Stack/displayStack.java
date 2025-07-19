package Stack;

import java.util.Stack;

public class displayStack {
    public static void displayReverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {return;}
        int top = s.pop();
        System.out.print(top+" ");
        displayReverseStack(s);
        s.push(top);
    }
    public static void displayStack(Stack<Integer> s) {
        if (s.isEmpty()) {return;}
        int top = s.pop();
        displayStack(s);
        System.out.print(top+" ");
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        displayReverseStack(st);
        System.out.println();
        System.out.println(st);
        displayStack(st);
        Stack<Integer> rt = new Stack<>();
//        while (!st.isEmpty()) {
//            rt.push(st.pop());
//        }
//
//        while (!rt.isEmpty()) {
//            int x = rt.pop();
//            System.out.println(x + " ");
//            st.push(x);
//        }
//        System.out.println(st);
//
//        int n = st.size();
//        int [] arr = new int[n];
//        for (int i = n-1; i >= 0; i--) {
//            arr[i] = st.pop();
//        }
//        for (int i = 0; i < n; i++) {
//            int x = arr[i];
//            System.out.println(arr[i] + " ");
//            st.push(x);
//        }

    }
}
