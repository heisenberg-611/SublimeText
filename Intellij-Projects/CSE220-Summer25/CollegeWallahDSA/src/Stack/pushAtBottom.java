package Stack;

import java.util.Stack;

public class pushAtBottom {
    public static void pushAtBottomRec(Stack<Integer> s, int x) {
        if(s.isEmpty()){
            s.push(x);
            return;
        }
        int top = s.pop();
        pushAtBottomRec(s,x);
        s.push(top);
    }
}