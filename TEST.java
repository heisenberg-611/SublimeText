public class TEST {
  public static String charShifter(String input, int n) {
    StringBuilder result = new StringBuilder();
    for (char c : input.toCharArray()) {
      if (Character.isLetter(c)) {
        char shiftedChar = (char) (c - n);
        if (Character.isLowerCase(c)) {
          if (shiftedChar < 'a') {
            shiftedChar = (char) ('z' - ('a' - shiftedChar) + 1);
          }
        } else {
          if (Character.isUpperCase(c) ) {
            shiftedChar = c;
          }
        }
        result.append(shiftedChar);
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String input = "Scary";
    int n = 3;
    String answer = charShifter(input, n);
    System.out.println(answer); // Output: CSE110 Etwi!
  }
}
