import java.util.Scanner;
public class CW3{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		char b = sc.next().charAt(0);
		int len = a.length();
			
     		for(int i = 0; i<=len-1; i++){
			if(a.charAt(i)==b){
			   	System.out.println();	
			   	continue;			
			}
			else{
				System.out.print(a.charAt(i));   		
			}
		}
	}
}