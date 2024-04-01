import java.util.Scanner;
public class HW4{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		int len = a.length();
		StringBuilder f = new StringBuilder();
   		String x = a.toLowerCase();
   		System.out.print(x.charAt(0));
		for(int i = 1; i<len; i++){	
			if(i%2!=0 ){
				String c = x.toUpperCase();
       			f.append(c.charAt(i));	
			}
			else{
				f.append(x.charAt(i));
				
		    }  
  
		}
		System.out.println(f);
	}
}