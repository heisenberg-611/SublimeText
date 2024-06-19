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

// import java.util.Scanner;

// public class Task9 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         String ans = "";

//         while (n != 0) {
//             int d = n % 10;
//             int y = d * 7;
//             ans = y + " " + ans;
//             n = n / 10;
//         }

//         System.out.println(ans);
//         sc.close();
//     }
// }