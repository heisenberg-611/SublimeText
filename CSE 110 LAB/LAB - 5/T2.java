public class T2 {
    public static void main(String[] args) {
        int x = 0, y = 0;
        int sum = 0;
        while(x < 10){
            y = x-3;
            System.out.println("y1 = "+y);
            y = 40;
            while( y > 22) {
                if ((sum > 30) && (sum < 40)) {
                    sum = sum + x * 2;
                    System.out.println("sum IF = " + sum);
                } else if ((sum > 40) && (sum < 50)) {
                    sum = sum + x * 3;
                    System.out.println("sum ELSE IF = " + sum);
                } else {
                    sum = sum + 23;
                    System.out.println("sum ELSE = " + sum);
                }
                System.out.println("sumF = "+sum);
                y = y - 10;
                System.out.println("yF = " + y);
            }
            x += 2;
            System.out.println("xF = "+x);
        }
    }
}
