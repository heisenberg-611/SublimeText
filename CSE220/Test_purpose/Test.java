import java.util.Scanner;

public class Test {

    public static void rowWise2Darray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void colWise2Darray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[j][i]+" ");
            }
        }
    }
    
    public static void sumAllElements(int[][] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                sum += arr[i][j];
            }
        }
        System.out.println("Sum of all elements is "+sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimensions of the array");
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println("Enter the elements of the array");
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        rowWise2Darray(arr);
        System.out.println();
        colWise2Darray(arr);
        System.out.println();
        sumAllElements(arr);
    }
}
