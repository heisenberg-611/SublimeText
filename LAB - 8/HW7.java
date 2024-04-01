import java.util.Scanner;
public class HW7{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String c = sc.nextLine();
		int count =0;
		for(int i = 0; i<=s.length()-1;i++){
			if(c.equals(s.charAt(i))){
				count++;
			}
		}
		System.out.print(count);
	}
}