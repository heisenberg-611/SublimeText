import java.util.Scanner;
public class Task9{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your CGPA: ");
		double x = sc.nextDouble();
		System.out.println("Enter your completed credit: ");
		int y = sc.nextInt();
		if(y>=30){
			if(x>=3.80 && x<=3.89){
				System.out.println("25 percent");
			}
			else if(x>=3.90 && x<=3.94){
				System.out.println("50 percent");
			}
			else if(x>=3.95 && x<=3.99){
				System.out.println("75 percent");
			}
			if(x == 4.00){
				System.out.println("100 percent");
			}
		}
		else{
			System.out.println("The student is not eligible for a waiver.");
		}				
	}
}