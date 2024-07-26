import java.util.Scanner;

public class Task2A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[]= new int[5];
        for(int i =0; i<5;i++) {
            arr[i] = sc.nextInt();
        }
        int l_pos=0;
        int s_pos=0;
        int largest = arr[0];
        int smallest = arr[0];
        for(int i = 0; i<arr.length; i++){
            if(largest < arr[i]){
                largest= arr[i];
                l_pos=i;
            }
            if(smallest > arr[i]){
                smallest = arr[i];
                s_pos=i;
            }
        }
        System.out.println("The largest number : "+largest+" was found at location "+l_pos+".");
        System.out.println("The smallest number : "+smallest+" was found at location "+s_pos+".");
    }
}

