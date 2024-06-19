import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        int prime_count = 0;
        
        for (int i = start; i <= end; i++) {
            if (i <= 1) {
                continue;
            }
            
            boolean primeConunter = true;
            for (int j = 2; j <= i/2; j++) {
                if (i % j == 0) {
                    primeConunter = false;
                    break;
                }
            }
            if (primeConunter) {
                prime_count++;
            }
        }
        System.out.println("There are " + prime_count + " prime numbers between " + start + " and " + end);
    }
}
