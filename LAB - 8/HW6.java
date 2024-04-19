import java.util.Scanner;

public class HW6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Enter a number: ");
            arr[i] = sc.nextInt();
            System.out.println("Enter a name: ");
            names[i] = sc.next();
            
        }
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(arr[i] > arr[j]) {
                    
                    int temp1 = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp1;

                    String temp2 = names[j];
                    names[j] = names[i];
                    names[i] = temp2;
                }
            }
        }
        System.out.println("Sorted array:");
        for(int i = 0; i < N; i++) {
            
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i = 0; i < N; i++) {
            
            System.out.print(names[i]+" ");
        }
    }
}
