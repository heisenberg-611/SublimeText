import java.util.Scanner;
public class Task1{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String x = sc.nextLine();
	String y = "";
		for(int i = x.length()-1; i>=0;i--){
			y+=x.charAt(i);
		}
		if(x.equals(y)){
			System.out.println("Palindrome");
		}
		else{
			System.out.println("Not a Palindrome");
		}
	}
}