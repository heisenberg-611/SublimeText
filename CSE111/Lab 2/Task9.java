// import java.util.Scanner;

// public class Task9{
// 	public static void main(String[] args){
// 		Scanner sc = new Scanner(System.in);
// 		int n = sc.nextInt();
// 		int digit_count = 0;
// 		while(n!=0){
// 			digit_count++;
// 			n = n / 10;
// 		}
// 		System.out.println(digit_count+" digits");
// 	}
// }

import java.util.Scanner;
import java.util.ArrayList;
public class Task9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = n;
		int digit_count = 0;
		ArrayList<Integer> f = new ArrayList<>();

		while (n != 0) {
			digit_count++;
			n = n / 10;
		}
		for (int i = 1; i <= digit_count; i++) {
			int d = c % 10;
			int y = d*7;
			f.add(y);
			c = c / 10;
		}
		for(int i = f.size()-1; i>=0; i--){
			System.out.print(f.get(i) + " ");
		}
		sc.close();
	}
}