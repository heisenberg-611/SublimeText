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
        
        int dj = 0;
        for(int i = 0; i < N; i++) {
            if(a[i] == searchNumber) {
                f = true;
                dj=i;
            }
        }
        if(f){
            System.out.println(searchNumber + " is at index " + dj);
        }
        else{
            System.out.println("Element not found.");
        }
    }
}
