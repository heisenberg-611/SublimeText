import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for array length
        System.out.print("Enter the length of the array: ");
        int length = sc.nextInt();

        // Input for array elements
        int[] arr = new int[length];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        // Input for target value
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        // Check for two elements summing up to the target value
        boolean found = false;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] + arr[j] == target) {
                    found = true;
                    index1 = i;
                    index2 = j;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        // Print the result
        if (found) {
            System.out.println("Combination of elements that add up to target value:");
            System.out.println("Element 1: " + arr[index1] + ", Index 1: " + index1);
            System.out.println("Element 2: " + arr[index2] + ", Index 2: " + index2);
        } else {
            System.out.println("Target value not found.");
        }
    }
}
