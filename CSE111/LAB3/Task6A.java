import java.util.Scanner;
public class Task6A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
           arr[i] = sc.nextInt();
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        if(n % 2 == 0){
            int median = (arr[n/2] + arr[n/2 - 1])/2;
            System.out.println("The median is "+median+".");
        }
        else{
            int median = arr[n/2];
            System.out.println("The median is "+median+".");
        }
    }
}