import java.util.Scanner;
public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weightAvg = 0;
        double sum1 = 0;
        double sum2 = 0;
        for(int i = 1; i <= 5; i++){
            double number = sc.nextDouble();
            double weight = sc.nextInt();
            sum1 += weight*number;
            sum2 += weight;
        }
        weightAvg = sum1/sum2;
        System.out.println("Weighted average = "+weightAvg);
    }
}