import java.util.Scanner;

public class HW4{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		int len = a.length();
		StringBuffer f = new StringBuffer();
   		String x = a.toLowerCase();
   		int d = 1;
		for(int i = 0; i<len; i++){
		if(x.charAt(i)>= 'a' && x.charAt(i)<='z'){	
				if(d%2==0){
					String c = x.toUpperCase();
       				f.append(c.charAt(i));	
				}
				else{
					f.append(x.charAt(i));
		    	}
		    	d++;
		    }
		    else{
		    	f.append(x.charAt(i));
		    }  
		}
		System.out.println(f);
	}
}