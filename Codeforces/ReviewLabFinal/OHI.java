public class OHI {

    public static void main(String[] args) {
        int n = 10; // Example value of n
        int sum = sumOdd(n);
        System.out.println("Sum of odd numbers from 1 to " + n + ": " + sum);
    }

    public static int sumOdd(int n) {
        if (n <= 0) {
            return 0; // Base case: If n is less than or equal to 0, return 0
        } else if (n % 2 == 0) {
            // If n is even, subtract 1 to make it odd and recursively call sumOdd
            return sumOdd(n - 1);
        } else {
            // If n is odd, add it to the sum of odd numbers from 1 to n-2
            return n + sumOdd(n - 2);
        }
    }
}
