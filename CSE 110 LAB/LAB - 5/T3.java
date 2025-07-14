public class T3 {
    public static void main(String[] args) {
        int x = 0, p = 0, sum = 0;
        p = 1;
        x = 2;
        double q;
        while(p<12){
            q = x + p - (sum+7/3)/3.0%2;
            System.out.println("q1 = "+q);
            sum = sum + (x++) + (int)q;
            System.out.println("x = "+x);
            System.out.println("sum1 = "+sum);
            if(x>5){
                p += 4/2;
                System.out.println("if p = "+p);
            }
            else {
                p += 3%1;
                System.out.println("else p = "+ p);
            }
        }
        sum = sum + p;
        System.out.println("sum2 = "+sum);
        System.out.println("pf= "+p);
    }
}