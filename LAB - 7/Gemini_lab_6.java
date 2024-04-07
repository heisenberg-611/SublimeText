import java.util.Scanner;

public class Gemini_lab_6
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        boolean isValid = true;

        if (password.length() < 8) {
            isValid = false;
        } else {
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    hasUppercase = true;
                } else if (ch >= 'a' && ch <= 'z') {
                    hasLowercase = true;
                } else if (ch >= '0' && ch <= '9') {
                    hasDigit = true;
                }
            }
            if (!(hasUppercase && hasLowercase && hasDigit)) {
                isValid = false;
            }
        }

        System.out.println(isValid ? "True" : "False");
        sc.close();
    }
}
