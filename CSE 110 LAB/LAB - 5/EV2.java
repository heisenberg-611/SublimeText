import java.util.Scanner;
public class EV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int divC=0;
            System.out.println("Enter number: ");
            int x = sc.nextInt();
            if (x % 2 != 0) {
                break;
            }
            for(int i = 1;i<=x;i++){
                if(x%i==0)
                    divC++;
            }
            System.out.println(x+" has "+divC+" divisors ");
        }
    }
}
