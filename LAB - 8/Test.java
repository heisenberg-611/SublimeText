import java.util.Scanner;
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
}

