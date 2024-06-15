import java.util.Scanner;
public class Task11{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		if(x<0){
			System.out.println(2*x);
		}
		else if(x>=0 && x<2){
			System.out.println(x+1);
		}
		else if(x>=2 && x<5){
			System.out.println((x*x)-1);
		}
		else if(x>=5){
			System.out.println((3*(x*x))+2);
		}
	}
}