import java.util.Scanner;
public class Task5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		String y = sc.nextLine();
		String fString = x+" "+y;
		int asciiSum = 0;
		for(int i = 0; i<fString.length();i++){
			if(fString.charAt(i)>='A' && fString.charAt(i)<='Z'){
				asciiSum += (int) fString.charAt(i);
			}
			if(fString.charAt(i)>='a' && fString.charAt(i)<='z'){
				asciiSum += (int) fString.charAt(i);
			}
		}
		System.out.println(fString);
		System.out.println(asciiSum);
	}
}