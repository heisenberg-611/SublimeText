import java.util.Scanner;

public class Task5{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		
		if(x>y && x>z){
			System.out.println("Largest number: "+x);
		}
		else if(y>x && y>z){
			System.out.println("Largest number: "+y);
		}
		else{
			System.out.println("Largest number: "+z);
		}	
	}
}