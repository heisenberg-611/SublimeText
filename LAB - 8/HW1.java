import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the length of the array: ");
        int N = sc.nextInt();
        double[] a = new double[N];
        for(int i = 0; i<N; i++){
            System.out.println("Enter a number: ");
            a[i]=sc.nextDouble();
        }
        double max = a[0];
        int maxi = 0;
        double min = a[0];
        int mini = 0;
        double sum = 0;
        double avg = 0;
        for(int i = 1; i<N; i++){
            if(a[i]>max){
                max = a[i];
                maxi = i;
            }
        }
        for(int i = 1; i<N; i++){
            if(a[i]<min){
                min = a[i];
                mini = i;
            }
        }
        for(int i = 0; i<N; i++){
            sum = sum + a[i];
            avg = sum/N;
        }
        System.out.println("Maximum element " + max + " found at index " + maxi);
        System.out.println("Minimum element " + min + " found at index " + mini);
        System.out.println("Summation: "+sum);
        System.out.println("Average: "+avg);
    }
}