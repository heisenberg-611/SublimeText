import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int Minimum = 0;
        int Maximum = 0;
        Double Average = 0.0;
        for(int i = 1; i<=10; i++){
            int n = sc.nextInt();
            sum += n;
            if(i == 1){
                Minimum = n;
                Maximum = n;
            }
            else{
                if(n < Minimum){
                    Minimum = n;
                }
                if(n > Maximum){
                    Maximum = n;
                }
            }
        }
        Average = (double)sum/10;
        System.out.println("Sum: "+sum);
        System.out.println("Minimum: "+Minimum);
        System.out.println("Maximum: "+Maximum);
        System.out.println("Average: "+Average);
        sc.close();
    }
}