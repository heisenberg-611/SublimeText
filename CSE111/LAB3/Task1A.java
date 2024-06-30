import java.util.Scanner;

public class Task1A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("N: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Input Array:");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("Remove Element: ");
        int x = sc.nextInt();
        boolean Found = false;
        for (int i = 0; i < N; i++) {
            if (arr[i] == x) {
                Found = true;
                for (int j = i; j < N - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                N--;
                i--;
            }
        }
        System.out.println("New Array:");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        if (!Found) {
            System.out.println("Element not found");
        }
        sc.close();
    }
}
