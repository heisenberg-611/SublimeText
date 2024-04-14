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
        
        boolean ss = true;
        for(int i = 0; i < M; i++) {
            boolean found = false;
            for(int j = 0; j < N; j++) {
                if(arr2[i] == arr1[j]) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                ss = false;
                break;
            }
        }
        
        if(ss) {
            System.out.println("Array2 is a subset of Array1.");
        } else {
            System.out.println("Array2 is not a subset of Array1.");
        }
    }
}
