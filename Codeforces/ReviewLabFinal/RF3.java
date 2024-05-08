public class RF3{
    
    public static int toDecimal(String binary) {
        // Convert binary string to decimal integer
        return Integer.parseInt(binary, 2);
    }

    public static String toHex(int decimal) {
        // Convert decimal integer to hexadecimal string
        return Integer.toHexString(decimal);
    }

    public static void main(String[] args) {
        // Example usage
        String binary = "1010";
        int decimal = toDecimal(binary);
        System.out.println("Decimal value of binary " + binary + " is: " + decimal);

        String hex = toHex(decimal);
        System.out.println("Hexadecimal value of decimal " + decimal + " is: " + hex);
    }
}