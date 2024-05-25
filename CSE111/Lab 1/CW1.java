import java.util.HashMap;
import java.util.Scanner;

public class CW1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, Integer> frequencies = new HashMap<>();

    while (true) {
      System.out.print("Enter a number (or 'STOP' to finish): ");
      String input = scanner.nextLine();

      if (input.equalsIgnoreCase("STOP")) {
        break;
      }

      try {
        int number = Integer.parseInt(input);
        frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number or 'STOP'.");
      }
    }

    if (frequencies.isEmpty()) {
      System.out.println("No numbers were entered.");
    } else {
      System.out.println("Frequency of numbers:");
      for (int number : frequencies.keySet()) {
        int count = frequencies.get(number);
        System.out.println(number + ": " + count);
      }
    }
  }
}
