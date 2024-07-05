public class UniversityTester {
    public static void main(String[] args) {
        University st1 = new University();
        University st2 = new University();
        if(st1.equals(st2)){
            System.out.println("Locations of two objects are same");
        } else {
            System.out.println("Locations of two objects are not same");
        }
        st1.name = "Imperial College London";
        st1.country = "England";
        st2.name = "Brac University";
        st2.country = "Bangladesh";
        System.out.println(st1.name);
        System.out.println(st1.country);
        System.out.println(st2.name);
        System.out.println(st2.country);
    }
}
