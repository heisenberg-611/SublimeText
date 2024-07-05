import java.util.*;

public class PalindromePossible {

    public static boolean canFormPalindrome(String str) {
        // Array to store character frequencies (assuming ASCII characters)
        int[] charCount = new int[256]; // Total ASCII characters

        // Count frequencies of each character in the string
        for (char c : str.toCharArray()) {
            charCount[c]++;
        }

        // Count how many characters have odd frequencies
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // A palindrome is possible if at most one character has an odd frequency
        return oddCount <= 1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String input1 = input.toLowerCase();

        if (canFormPalindrome(input1)) {
            System.out.println("Palindrome can be formed");
        } else {
            System.out.println("Palindrome cannot be formed");
        }

        scanner.close();
    }
}
