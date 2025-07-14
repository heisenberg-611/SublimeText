import java.util.Scanner;
public class EV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0, m = 0;
        for (int i = 1; i <= N; i++) {
            sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
            m -= sum;
        }
        System.out.println(m);
    }
}