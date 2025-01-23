import java.util.Scanner;

public class HW5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int N = sc.nextInt();

        int[] arr = new int[N];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < N; i++) {
        	System.out.println("Enter a number: ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Original array: ");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int dj = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[dj]) {
                    dj = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[dj];
            arr[dj] = temp;
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

