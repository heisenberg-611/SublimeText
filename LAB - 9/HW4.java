import java.util.Scanner;
public class HW4 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        oneToN(N);
    }
    
    public static void oneToN(int n){
        if (n <= 0) {
            return;
        }
        oneToN(n-1); 
        System.out.print(n + " ");
    }
}