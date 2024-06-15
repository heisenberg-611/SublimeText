import java.util.Scanner;
public class Task6{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a year: ");
		int x = sc.nextInt();
		
		if(x % 4 == 0){
			if(x % 100 != 0 || x % 400 == 0){
				System.out.println(x + " is a leap year.");
			}
			else{
				System.out.println(x + " is not a leap year.");
			}
		}
		else{
			System.out.println(x + " is not a leap year.");
		}
	}
}