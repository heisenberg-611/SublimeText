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
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                    int temp2 = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp2;
                }
            }
        }
        System.out.print("Sorted array: ");
        for(int i = 0; i < N; i++) {
            System.out.println(names[i]);
            System.out.println(arr[i]);
            
        }
    }
}
