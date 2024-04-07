/*import java.util.Scanner;
public class Test{
public static void main(String[] args) {
Scanner input = new Scanner (System. in);
String text = input.nextLine();
String newText = "";
int c = 1; 
int i = 0;
while(i<text.length()){
	int t = text.charAt(i);
	if(t>=65 && t<=90){
		t+=32;
	}
	if(t>=97&&t<=122){
		if(c%2==0){
			newText += (char) (t-32);
		}
		else{
			newText += (char) t;
		}
		c++;
	}
	else{
		newText += (char) t;
	}
	i++;
  }
System.out.println(newText);
 }
}*/
import java.util.Scanner;
public class Test{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        sc.close();
        int len1=s1.length();
        int len2=s2.length();
        int count=0;
        int count1=0;
        for(int i=0;i<len1-(len2-1);i++){
            count1=0;
            for(int j=0;j<len2;j++){
                if(s1.charAt(i+j)!=s2.charAt(j)){
                    count1++;
                    continue;
                }
            }
            if(count1==0){
                count++;
            }
        }
        System.out.println(count);
    }
}

