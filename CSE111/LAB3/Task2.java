import java.util.Scanner;
public class Task2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        for(int i = 0; i < x.length(); i++){
            int ascii = (int) x.charAt(i);
            int asci = ascii-1;
            if(ascii == 97){
                asci = 122;
            }
            char ch = (char) asci;
            System.out.print(ch);
        }
    }
}