import java.util.Scanner;

public class HW5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		String g = a.toLowerCase();
		String h = b.toLowerCase();
		StringBuffer x = new StringBuffer();
		for(int i = 0; i<a.length(); i++){
			boolean dj = false;
			for(int j = 0; j<b.length();j++){
			
				if(g.charAt(i)==h.charAt(j)){
				dj = true;
				break;				
			}
		}
			if(dj == false){
				x.append(a.charAt(i));
			}
		}
		//String f = x.toString();
		System.out.println(x);
	}
}