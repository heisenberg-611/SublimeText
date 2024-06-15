import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your studentID: ");
        String studentId = sc.nextLine();        
        int l = studentId.length();
        System.out.println(studentId.charAt(7));
        System.out.println(studentId.charAt(6));
    }
}
