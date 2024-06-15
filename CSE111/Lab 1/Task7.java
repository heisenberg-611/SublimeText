import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        int x = sc.nextInt();
        
        if (x % 5 == 0 && x % 7 == 0) {
            System.out.println("Divisible by both");
        } 
        else if (x % 5 == 0) {
            System.out.println("Invalid: Divisible by 5 only");
        } 
        else if (x % 7 == 0) {
            System.out.println("Invalid: Divisible by 7 only");
        } 
        else {
            System.out.println("No");
        }
        sc.close();
    }
}
