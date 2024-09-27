public class Shape2D {

    public int length;
    public int breadth;
    public int Side3;
    public String type;

    Shape2D(int n) {
        this.length = n;
        this.type = "Square";
        System.out.println("A Shape has been created with length: " + this.length);
    }

    public Shape2D(int i, int i1) {
        this.length = i;
        this.breadth = i1;
        this.type = "Rectangle";
        System.out
                .println("A Rectangle has been created with length: " + this.length + " and breadth: " + this.breadth);
    }

    public Shape2D(int n, int i, int i1) {
        this.length = n;
        this.breadth = i;
        this.Side3 = i1;
        this.type = "Triangle3sides";
        System.out.println("A Triangle has been created with the following sides: " + n + ", " + i + ", " + i1);
    }

    public Shape2D(int n, int i, String triangle) {
        this.length = n;
        this.breadth = i;
        this.type = triangle;
        System.out.println("A Triangle has been created with length: " + this.length + " and base :" + this.breadth);
    }

    public void area() {
        switch (type) {
            case "Square" -> System.out.println("The area of a square is " + (double) this.length * this.length);
            case "Rectangle" -> System.out.println("The area of a rectangle is " + (double) this.length * this.breadth);
            case "Triangle" ->
                System.out.println("The area of a triangle is " + ((double) this.length * this.breadth) / 2);
            case "Triangle3sides" -> {
                double s = (double) (this.breadth * (Math.sqrt((this.Side3 * this.Side3) - (this.length * this.length)))/2);
                s = Math.floor(s * 100) / 100;
                System.out.printf("The area of the Triangle is: %.2f%n", s);
            }
        }
    }

    public static void main(String[] args) {
        Shape2D sq = new Shape2D(5);
        System.out.println("---------1----------");
        sq.area();
        System.out.println("---------2----------");
        Shape2D rectangle = new Shape2D(5, 6);
        System.out.println("---------3----------");
        rectangle.area();
        System.out.println("---------4----------");
        Shape2D tri1 = new Shape2D(5, 6, "Triangle");
        System.out.println("---------5----------");
        tri1.area();
        System.out.println("---------6----------");
        Shape2D tri2 = new Shape2D(5, 6, 7);
        System.out.println("---------7----------");
        tri2.area();
        System.out.println("---------8----------");
    }

}
