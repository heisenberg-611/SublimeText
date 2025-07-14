
//Write a Java program that will ask for a range
// (a starting number and an ending number) from the
// user and print all the Armstrong numbers between that range.
import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter lower range: ");
        int lower=sc.nextInt();
        System.out.println("Enter upper range: ");
        int upper=sc.nextInt();
        int c = lower;
        while(c<=upper)
        {
            // cheak armstrong;
            int t=c, digits=0;
            while(t!=0){
                digits++;
                t/=10;
            }
            t=c;
            int sum=0;
            while(t!=0)
            {
                int remainder=t%10;
                sum+=(int)Math.pow(remainder,digits);
                t/=10;
            }
            if(c==sum)
            {
                System.out.println(c);
            }
            c++;
        }
    }
}

