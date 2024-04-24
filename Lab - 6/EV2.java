import java.util.Scanner;

public class EV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int vcount = 0;
        int ccount = 0;
        for (int i = 0; i < a.length(); i++) {
            char ch = Character.toLowerCase(a.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) {
                vcount++;
            } else if (ch >= 'b' && ch <= 'z' && ch != 'e' && ch !='i' && ch !='o' && ch !='u') {
                ccount++;
            }
        }
        
        if(ccount==0 || vcount==0){
        	System.out.println("Blimey! No Plunder!!");
        }
        else if (vcount % 3 == 0 && ccount % 5 == 0) {
            System.out.println("Aaaar! Me Plunder!!");
        }
        else {
            System.out.println("Blimey! No Plunder!!");
        }
    }
}