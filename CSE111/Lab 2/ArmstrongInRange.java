import java.util.Scanner;

public class ArmstrongInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter starting number: ");
        int start = scanner.nextInt();

        System.out.print("Enter ending number: ");
        int end = scanner.nextInt();

        System.out.println("Armstrong numbers between " + start + " and " + end + " are:");

        // Loop from start to end (inclusive)
        for (int number = start; number <= end; number++) {
            if (isArmstrongNumber(number)) {
                System.out.print(number + " ");
            }
        }

        System.out.println();
        scanner.close();
    }

    // Method to check if a number is an Armstrong number
    public static boolean isArmstrongNumber(int num) {
        int originalNum = num;
        int sumOfCubes = 0;
        int numberOfDigits = String.valueOf(num).length(); // More efficient for larger ranges

        while (num > 0) {
            int digit = num % 10;
            sumOfCubes += Math.pow(digit, numberOfDigits);
            num /= 10;
        }

        return originalNum == sumOfCubes;
    }
}