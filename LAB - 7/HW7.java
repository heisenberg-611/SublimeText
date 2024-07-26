import java.util.Scanner;

public class HW7{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String c = sc.nextLine();
		int count =0;
		for(int i = 0; i<=s.length()-c.length();i++){
			if(s.substring(i, i+c.length()).equals(c)){
				count++;
			}
		}
		System.out.print("Occurrence: "+count+" times");
	}
}