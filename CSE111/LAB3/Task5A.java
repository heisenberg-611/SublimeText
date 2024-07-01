import java.util.Scanner;

public class Task5A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.println("Please enter the elements of the array: ");
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int chki = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[chki] = arr[i];
                chki++;
            }
        }
        System.out.println("Removed elements: " + (N - chki));
        System.out.print("New Array: ");
        for (int i = 0; i < chki; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
