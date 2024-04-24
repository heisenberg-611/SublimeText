import java.util.Scanner;

public class HW3 {

    Scanner sc = new Scanner(System.in);

    public static double calcTax(double age, double salary) {
        double tax = 0;
        if (age >= 18 && salary >= 10000 && salary <= 20000) {
            tax = salary * (7.0/100);
        } else if (age >= 18 && salary >= 20000) {
            tax = salary * (14.0/100);
        }
        return tax;
    }

    public static void calcYearlyTax() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Age: ");
        double age = sc.nextInt();
        double sum = 0;
        for (int i = 1; i <= 12; i++) {
            System.out.print("Enter salary: ");
            int salary = sc.nextInt();
            double tax = calcTax(age, salary);
            System.out.println("Month" + i + " tax: " + tax);
            sum = sum + tax;
        }
        System.out.println("Total Yearly Tax: " + sum);
    }

    public static void main(String[] args) {
        calcYearlyTax();
    }
}
