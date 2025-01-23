import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        showDiamond(n);
    }
    
    public static void showDots(int n){
        for(int i=0; i<n; i++){
            System.out.print(".");
        }
    }

    public static void showPalindrome(int n){
        for(int i=1; i<=n; i++){
            System.out.print(i);
        }
        for(int i=n-1; i>=1; i--){
            System.out.print(i);
        }
    }

    public static void showDiamond(int n){
        for(int i=1; i<n; i++){
            showDots(n-i);
            showPalindrome(i);
            showDots(n-i);
            System.out.println();
        }

        for(int i=n;i>=1;i--){
            showDots(n-i);
            showPalindrome(i);
            showDots(n-i);;
            System.out.println();
        }
    }
}