import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int len = x.length();
        for(int i = 0; i<len; i++){
            for(int j = 0; j<=i;j++){
                System.out.print(x.charAt(j));
            }
            System.out.println();
        }
    }
}