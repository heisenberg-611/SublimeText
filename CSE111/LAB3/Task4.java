import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String a = sc.nextLine();
            char[] arr = a.toCharArray();
            int N = arr.length;
            boolean dPl = false;
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean Counted = false;
                for (int k = 0; k < i; k++) {
                    if (arr[i] == arr[k]) {
                        Counted = true;
                        break;
                    }
                }
                if (Counted) {
                    continue;
                }
                for (int j = 0; j < N; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }
                if (count > 1) {
                    System.out.println("'" + arr[i] + "'" + " has been counted " + count + " times in the word " + "''" + a + "''");
                    dPl = true;
                }
                count = 0;
            }
            if (!dPl) {
                System.out.println("You entered " + a);
                break;
            }
            else{
                System.out.println("Please enter another word.");
            }
        }
        sc.close();
    }
}