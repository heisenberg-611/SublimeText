import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int Minimum = 0;
        int Maximum = 0;
        Double Average = 0.0;
        int o_counter = 0;
        int number_counter = 0;
        while (o_counter < 3) {
            int x = sc.nextInt();
            if (x != 0) {
                number_counter++;
                sum += x;
                if (x == 1) {
                    Minimum = x;
                    Maximum = x;
                } else {
                    if (x < Minimum) {
                        Minimum = x;
                    }
                    if (x > Maximum) {
                        Maximum = x;
                    }
                }
            } else {
                o_counter++;
            }
        }
        if(number_counter > 1){
        Average = (double) sum / number_counter;
        System.out.println("Sum: " + sum);
        System.out.println("Minimum: " + Minimum);
        System.out.println("Maximum: " + Maximum);
        System.out.println("Average: " + Average);
        }
        else{
            System.out.println("No numbers found.");
        }
        sc.close();
    }
}
