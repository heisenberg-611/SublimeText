import java.util.Scanner;

public class HW1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();

        int sum = specialSum(n);
        System.out.println("Special sum up to " + n + ": " + sum);
    }

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is perfect
    public static boolean isPerfect(int num){
        int sum=0;
        for(int i=1;i<num;i++){
            if(num%i==0){
                sum+=i;
            }
        }
        if(sum==num){
            return true;
        }
        return false;
    }

    // Method to calculate the special sum
    public static int specialSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i) || isPerfect(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
