import java.util.Scanner;

public class HW5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int ct = 0;
        int initNum = 2;
        while (ct < N) {
            int sum = 0;
            for (int i = 1; i < initNum; i++) {
                if (initNum % i == 0) {
                    sum += i;
                }
            }
            if (sum == initNum) {
                System.out.println(initNum);
                ct++;
            }
            initNum++;
        }
    }
}