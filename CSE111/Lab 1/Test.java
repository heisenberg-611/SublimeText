public class Test {
    int m = 0, n = 1;
    int metA(int n){
        n += m + 4;
        int s = n + this.n;
        if (s%2 == 0) return s;
        this.n = (++this.m) + this.m;
        this.n = n + metB(this.m, n);
        System.out.printf("%d %d %d\n", m, n, s);
        return s+this.n;
    }
    private int metB(int m, int s) {
        System.out.println(m+" "+n+" "+s);
        return - (m++) + (n++) - (++this.m);
    }
}
