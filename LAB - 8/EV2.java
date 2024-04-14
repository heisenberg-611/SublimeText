import java.util.Scanner;

public class EV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean f = false;
        int[] a = new int[N];
        
        for(int i = 0; i < N; i++) {
            System.out.println("Enter a number: ");
            a[i] = sc.nextInt();
        }
        
        int searchNumber = sc.nextInt();
        int i = 0;
        for( i = 0; i < N; i++) {
            if(a[i] == searchNumber) {
                f = true;
            }
        }
        if(f){
            System.out.println(searchNumber + " is at index " + i);
        }
        else{
            System.out.println("Element not found.");
        }
    }
}
