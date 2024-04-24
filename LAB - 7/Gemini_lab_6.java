import java.util.Scanner;

public class Gemini_lab_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter your age: ");
        int age = sc.nextInt();
        System.out.printf("Enter your salary: ");
        int salary = sc.nextInt();
        double t = calcTax(age, salary);
        System.out.printf("Tax: %.2f", t);
    }

    static double calcTax(int age, int salary) {
        if (age < 18 && salary < 10000) {
            return 0;
        } else {
            double taxRate = 0.2; 
            return salary * taxRate;
        }
    }
}
