import java.util.TreeSet;
import java.util.Scanner;

public class HW3 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter the length of the arr1: ");
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        System.out.println("Please enter the elements of the arr1: ");
        for(int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        
        System.out.println("Please enter the length of the arr2: ");
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        System.out.println("Please enter the elements of the arr2: ");
        for(int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }
        
        if (!SS(arr1, arr2)) {
            System.out.println("arr2 is not a subset of arr1");
        } else {
            System.out.println("arr2 is a subset of arr1");
        }
    }

    public static boolean SS(int[] arr1, int[] arr2) {
    
        if (arr2.length > arr1.length) {
            return false;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr1) {
            set.add(i);
        }

        for (int i : arr2) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
