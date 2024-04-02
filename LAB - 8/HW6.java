import java.util.Scanner;

public class HW6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        boolean dj = true;
        boolean dj1 = false;
        boolean dj2 = false;
        boolean dj3 = false;
        boolean dj4 = false;
        if (a.length() < 8) {
            dj = false;
        } else {
            for (int i = 0; i < a.length(); i++) {
                char ch = a.charAt(i);
                if ((ch >= 'A' && ch <= 'Z')) {
                    dj1 = true;
                } else if ((ch >= 'a' && ch <= 'z')) {
                    dj2 = true;
                } else if ((ch >= '0' && ch <= '9')) {
                    dj3 = true;
                } else if ((ch >= ' ' && ch <= '~')) {
                    dj4 = true;
                }
            }
        }
        if (!(dj && dj1 && dj2 && dj3 && dj4)) {
           dj = false;
        }
        System.out.println(dj);    
    }
}
