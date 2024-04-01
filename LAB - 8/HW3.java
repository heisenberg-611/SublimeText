import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        // Concatenate the strings excluding common characters
        StringBuffer x = new StringBuffer();
        for (int i = 0; i < a.length(); i++) {
            char d = a.charAt(i);
            if (b.indexOf(d) == -1) {
                x.append(d);
            }
        }

        for (int i = 0; i < b.length(); i++) {
            char d = b.charAt(i);
            if (a.indexOf(d) == -1) {
                x.append(d);
            }
        }

        // Convert the result to uppercase and print
        String f = x.toString().toUpperCase();
        System.out.println(f);
    }
}
