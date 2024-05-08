public class RF4 {
    
    public static void getScores(char[] studentGrades, int[] studentScores) {
        for (int i = 0; i < studentScores.length; i++) {
            switch (studentGrades[i]) {
                case 'A':
                    studentScores[i] = 100;
                    break;
                case 'B':
                    studentScores[i] = 90;
                    break;
                case 'C':
                    studentScores[i] = 70;
                    break;
                default:
                    studentScores[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        char[] studentGrades = {'A', 'B', 'C', 'D', 'F'};
        int[] studentScores = new int[studentGrades.length];

        getScores(studentGrades, studentScores);

        // Print student scores
        System.out.println("Student Scores:");
        for (int score : studentScores) {
            System.out.println(score);
        }
    }
}
