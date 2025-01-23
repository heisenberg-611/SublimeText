import java.util.Scanner;
public class CW2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
	    String c = a.toLowerCase();
		int len = a.length();
		char[] arr= new char[len];
		int j=0;
		for(int i = len-1; i>=0; i--){
			arr[j]=c.charAt(i);
			j++;
		}
		String b = new String(arr);
		if(c.equals(b)){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
}