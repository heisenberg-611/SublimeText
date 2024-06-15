import java.util.Scanner;
public class Task10{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		if(x%2 == 0 && x%5 == 0){
			System.out.println("Multiple of 2 and 5 both");
		}
		else if(x%2 == 0){
			System.out.println(x);
		}
		else if(x%5 == 0){
			System.out.println(x);
		}
		else{
			System.out.println("Not a multiple we want");
		}
	}
}