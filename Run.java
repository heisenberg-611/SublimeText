import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        String lowercase = "";
        String word = "";
        int d = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 97 && ch <= 122) {
                if (d % 2 != 0) {
                    word += ch;
                    d++;
                } else {
                    int chl = (int) ch;
                    chl -= 32;
                    word += (char) chl;
                    d++;
                }
            } else {
                word += ch;
            }
        }
        System.out.print(word);
    }
}
