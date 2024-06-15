import java.util.Scanner;
public class Task8{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int studentId = sc.nextInt();
		int x = studentId/1000000;
		int y = studentId%1000000;
		int z = y/100000;
		if(z == 1){
			System.out.print("Student joined BRAC in Spring "+x);
		}
		else if(z == 3){
			System.out.print("Student joined BRAC in Summer "+x);
		}
		else if(z == 2){
			System.out.print("Student joined BRAC in Fall "+x);
		}
	}
}