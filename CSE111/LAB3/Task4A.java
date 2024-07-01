import java.util.Scanner;
public class Task4A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("N: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for(int i = 0; i < N; i++){
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
            for(int j = 0; j < N; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            System.out.println(arr[i]+" - "+count+" times");
            count = 0;
        }
    }
}