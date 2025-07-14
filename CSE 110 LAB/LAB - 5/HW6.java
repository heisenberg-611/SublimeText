import java.util.Scanner;

public class HW6 {
    public static void main(String[] args) {
        Scanner dj = new Scanner(System.in);

        System.out.println("Start: ");
        int start = dj.nextInt();

        System.out.println("Stop: ");
        int end = dj.nextInt();

        for (int i = start; i <= end; i++) {
            System.out.println("Times table of " + i + ":");
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }
}