// Write a Java program that will ask the 
// user to input a word in small letters where
//  each of its alphabets is unique and has not 
//  been entered before by the user. 
//  If the user does input a word that consists 
//  of duplicate alphabets, the program should 
//  reject the user’s input and ask for another 
//  word.
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        StringBuffer fString = new StringBuffer();
        int dlCount = 0;
        int count = 0;
        for(int i = 0; i<a.length(); i++){
            for(int j = 0; j<a.length(); j++){
                if(a.charAt(i) == a.charAt(j)){
                    dlCount++;
                    if(dlCount > 1){
                        System.out.println("Duplicate found");
                        a = sc.nextLine();
                        i = 0;
                        j = 0;
                    }
                }
                dlCount = 0;
            }
        }
        System.out.println(fString);
        System.out.println(dlCount);
        sc.close();
    }
}