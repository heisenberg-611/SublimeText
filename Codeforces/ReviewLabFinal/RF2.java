import java.util.Set;
import java.util.HashSet;
public class RF2 {
    
    public static boolean isHappyNumber(int n) {
        // Set to store seen numbers to detect cycles
        Set<Integer> seen = new HashSet<>();
        
        // Iterate until n becomes 1 (happy number) or enters a cycle
        while (n != 1) {
            // Calculate the sum of the squares of digits
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            // If the sum is already seen, it's an unhappy number
            if (seen.contains(sum)) {
                return false;
            }
            // Add the sum to the set of seen numbers
            seen.add(sum);
            // Update n with the sum for the next iteration
            n = sum;
        }
        
        // If n becomes 1, it's a happy number
        return true;
    }

    public static void main(String[] args) {
        int number = 13;
        System.out.println(number + " is a happy number: " + isHappyNumber(number));
        
        number = 4;
        System.out.println(number + " is a happy number: " + isHappyNumber(number));
    }
}
