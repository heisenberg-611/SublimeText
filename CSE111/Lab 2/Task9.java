// import java.util.Scanner;

// public class Task9{
// 	public static void main(String[] args){
// 		Scanner sc = new Scanner(System.in);
// 		int n = sc.nextInt();
// 		int digit_count = 0;
// 		while(n!=0){
// 			int x = n%10;
// 			digit_count++;
// 			n = n / 10;
// 		}
// 		System.out.println(digit_count);
// 	}
// }

import java.util.Scanner;

public class Task9{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int digit_count = 0;
		while(n>0){
			int x = n%10;
			System.out.print(x*7+" ");
			n = n / 10;
		}
	}
}