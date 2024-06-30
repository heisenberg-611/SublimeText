import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        
        StringBuffer f = new StringBuffer();
        int count = 1;
        char c = a.charAt(0);
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) == c) {
                count++;
            } else {
                
                f.append(c).append(count);
                count = 1;
                c = a.charAt(i);
            }
        }
        f.append(c);
        System.out.print(f);
    }
}