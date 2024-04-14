import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] uniqueArray = new int[N]; // Initialize with maximum possible size
        
        // Read the input array
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Count of unique elements found
        int uniqueCount = 0;
        
        // Loop through the input array to find unique elements
        for (int i = 0; i < N; i++) {
            boolean isUnique = true;
            // Check if the current element is already present in the new array
            for (int j = 0; j < uniqueCount; j++) {
                if (arr[i] == uniqueArray[j]) {
                    isUnique = false;
                    break;
                }
            }
            // If the current element is unique, add it to the new array
            if (isUnique) {
                uniqueArray[uniqueCount++] = arr[i];
            }
        }
        
        // Print the original array
        System.out.println("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Print the new array containing unique elements
        System.out.println("New array (unique elements): ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(uniqueArray[i] + " ");
        }
    }
}
