public class Test3 {
    public static void main(String[] args) {
        Circle dj1 = new Circle();
        double radius = dj1.radius;
        int radius2 = (int) radius;
        double area = Math.PI*radius*radius;
        double circumference = 2*Math.PI*radius;
        System.out.println("Radius of the circle is " + radius2);
        System.out.println("The area of circle is "+area);
        System.out.println("The circumference of the circle is "+circumference);
    }
}
