public class T4 {
    public static void main(String[] args) {
        int x = 0;
        int sum = 0;
        while (x<6){
            System.out.println("x1 = "+x);
            int y = x + 1;
            System.out.println("y1 = "+y);
            while (y<9){
                if(x%y==0){
                    break;
                }
                sum = (sum % 3)+x-y*3;
                System.out.println("sum = "+sum);
                y=y+1;
                System.out.println("y2 = "+y);
            }
            if (x>5){
                x++;
            }
            else{
                x+=2;
                System.out.println("else x2 = "+x);
            }
        }
    }
}