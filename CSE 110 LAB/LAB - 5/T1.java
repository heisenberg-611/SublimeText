public class T1 {
    public static void main(String[] args) {

        int x = 0, i = 0, sum = 0;
        i = 1;
        x = 2;
        while (i < 20){
            x = x + i;
            System.out.println("x="+x);
            System.out.println("i1="+i);
            sum = sum + x + 1;
            System.out.println("sum1="+sum);
            System.out.println("Before if complete");
            if (x > 5){
                i += 2;
                System.out.println("i2="+i);
                System.out.println("Within if");
            }
            else {
                i += 3;
                System.out.println("i3="+i);
                System.out.println("Within else");
            }
        }
        sum = sum + i;
        System.out.println("sum2="+sum);
        System.out.println("i4="+i);
        System.out.println("Program ends");
    }
}
