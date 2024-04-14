import java.util.Scanner;

public class EV1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i = 0; i<N; i++){
            a[i]=sc.nextInt();
        }
        for(int i = 0; i<N; i++){
            if(a[i]>0){
                a[i]=1;
            }
            else if(a[i]<0){
                a[i] = 0;
            }
        }
        for(int i=0; i<N; i++){
            System.out.print(a[i]+" ");
        }

    }
}