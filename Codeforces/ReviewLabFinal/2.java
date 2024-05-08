import java.util.regex.*;

public class 2{
    
    public static int countValidEmails(String[] emails) {
        // Regular expression pattern for valid email address
        String pattern = "^[a-zA-Z][a-zA-Z0-9._]*@[a-zA-Z]+\\.[a-zA-Z]+$";
        
        // Counter for valid emails
        int validCount = 0;
        
        // Iterate through the emails and check for validity
        for (String email : emails) {
            if (email.matches(pattern)) {
                validCount++;
            }
        }
        
        return validCount;
    }

    public static void main(String[] args) {
        // Example usage
        String[] emails = {"test@example.com", "invalid_email@", "another.valid@example.com", "no_dot@examplecom"};
        System.out.println("Number of valid email addresses: " + countValidEmails(emails));
    }
}
