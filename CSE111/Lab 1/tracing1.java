public class tracing1 {
    public static void main(String[] args) {
        Test m = new Test();
        m.n = m.m = 5;
        Test n = new Test();
        n.m = m.metA(3);
        n.n = n.metA(3);
        System.out.println(m.m+m.n+" "+n.n+" "+n.m);
    }
}

