import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        StringBuilder f = new StringBuilder();
        int len = a.length();
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == ' '){
                f.append(a, i + 1, len).append(" ");
                len = i;
            }else if (i == 0) {
                f.append(a, i, len);
            }
        }
        System.out.println(f.toString());
    }
}