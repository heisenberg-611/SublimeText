import java.util.Scanner;

public class Chatgpt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        
        // Input the split character
        System.out.print("Enter the split character: ");
        char splitChar = scanner.nextLine().charAt(0);
        
        // Split the string
        String[] parts = splitString(inputString, splitChar);
        
        // Output the result
        System.out.println("String after splitting:");
        for (String part : parts) {
            System.out.println(part);
        }
        
        scanner.close();
    }
    
    public static String[] splitString(String input, char splitChar) {
        int length = input.length();
        int count = 0;
        
        // Count the number of splits to determine the array size
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == splitChar) {
                count++;
            }
        }
        
        // Initialize the array to store the split parts
        String[] parts = new String[count + 1];
        
        // Split the string
        int index = 0;
        StringBuilder part = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == splitChar) {
                parts[index++] = part.toString();
                part = new StringBuilder();
            } else {
                part.append(currentChar);
            }
        }
        
        // Add the last part to the array
        parts[index] = part.toString();
        
        return parts;
    }
}
