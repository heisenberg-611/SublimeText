public class TesterStudent {
    public static void main(String[] args) {
        Student1 s1 = new Student1();
        Student1 s2 = new Student1();
        Student1 s3 = null;
        s1.name = "Student1 One";
        s1.cgpa = 2.3;
        s3 = s1;
        s2.name = "Student1 Two";
        s2.cgpa = s3.cgpa + 1;
        s3.name = "New Student1";
        System.out.println(s1.name);
        System.out.println(s2.name);
        System.out.println(s3.name);
        System.out.println(s1.cgpa);
        System.out.println(s2.cgpa);
        System.out.println(s3.cgpa);
        s3 = s2; s1.name = "old Student1";
        s2.name = "older Student1";
        s3.name = "oldest Student1";
        s2.cgpa = s1.cgpa - s3.cgpa + 4.5;
        System.out.println(s1.name);
        System.out.println(s2.name);
        System.out.println(s3.name);
        System.out.println(s1.cgpa);
        System.out.println(s2.cgpa);
        System.out.println(s3.cgpa);
    }
}
