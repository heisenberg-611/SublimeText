import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count500 = 0;
        int count100 = 0;
        int count50 = 0;
        int count10 = 0;
        int count5 = 0;
        int count1 = 0;

        for(;n>=500;n-=500){
            count500++;
        }
        for(;n>=100;n-=100){
            count100++;
        }
        for(;n>=50;n-=50){
            count50++;
        }
        for(;n>=10;n-=10){
            count10++;
        }
        for(;n>=5;n-=5){
            count5++;
        }
        for(;n>=1;n-=1){
            count1++;
        }


        if(count500>0){
            System.out.println(count500+" 500's notes.");
        }
        if(count100>0){
            System.out.println(count100+" 100's notes.");
        }
        if(count50>0){
            System.out.println(count50+" 50's notes.");
        }
        if(count10>0){
            System.out.println(count10+" 10's notes.");
        }
        if(count5>0){
            System.out.println(count5+" 5's notes.");
        }
        if(count1>0){
            System.out.println(count1+" 1's notes.");
        }
        sc.close();
    }
}
