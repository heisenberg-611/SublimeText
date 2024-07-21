import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = sc.nextLine();

        StringBuffer fString = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (fString.length() == 0 || fString.charAt(fString.length() - 1) != ch) {
                fString.append(ch);
            }
        }
        System.out.println(fString);
        sc.close();
    }
}

