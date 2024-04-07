import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        StringBuffer f = new StringBuffer();
        int len = a.length();
        for (int i = len - 1; i >= 0; i--) {
            if (a.charAt(i) == ' '){
                f.append(a, i + 1, len).append(" ");
                len = i;
            }else if (i == 0) {
                f.append(a, i, len);
            }
        }
        System.out.println(f);
    }
}