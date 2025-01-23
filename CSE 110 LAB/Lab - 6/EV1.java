import java.util.Scanner;
public class EV1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		int len = a.length();
		char[] arr= new char[len];
		int j=0;
		for(int i = len-1; i>=0; i--){
			arr[j]=a.charAt(i);
			j++;
		}
		String b = new String(arr);
		System.out.println(b);
	}
}