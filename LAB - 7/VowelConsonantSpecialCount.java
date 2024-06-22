public class VowelConsonantSpecialCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        int vowelCount = 0;
        int consonantCount = 0;
        int otherCount = 0;

        for (char c : text.toCharArray()) {
            c = Character.toLowerCase(c); // Convert to lowercase for case-insensitive counting

            if (isVowel(c)) {
                vowelCount++;
            } else if (isConsonant(c)) {
                consonantCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
        System.out.println("Others (spaces, special characters): " + otherCount);

        scanner.close();
    }

    // Method to check if a character is a vowel
    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    // Method to check if a character is a consonant (excluding special characters and spaces)
    public static boolean isConsonant(char c) {
        return c >= 'a' && c <= 'z' && !isVowel(c);
    }
}
