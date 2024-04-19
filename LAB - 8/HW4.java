import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter the length of the array: ");
        int length = sc.nextInt();

        int[] arr = new int[length];
        System.out.println("Please enter the elements of the array:");
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

 
        System.out.print("Please enter the target value: ");
        int dj = sc.nextInt();

        boolean f = false;
        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] + arr[j] == dj) {
                    f = true;
                    idx1 = i;
                    idx2 = j;
                    break;
                }
            }
            if (f) {
                break;
            }
        }

        if (f) {
            System.out.print("Elements need to be added: ");
            System.out.print(arr[idx1]+" and ");
            System.out.print(arr[idx2]);
            System.out.println();
            System.out.print("Index of the elements: ");
            System.out.print(idx1+" and ");
            System.out.print(idx2);
        } else {
            System.out.println("Target value not found.");
        }
    }
}
