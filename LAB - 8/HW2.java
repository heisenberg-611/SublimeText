
import java.util.LinkedHashSet; 
import java.util.Scanner;

public class HW2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the length of the array: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.println("Please enter the elements of the array: ");
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int i : arr) {
            set.add(i);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(set);
    }
}
