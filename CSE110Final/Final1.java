import java.util.Scanner;

public class Final1 {
    public static void main(String[] args) {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter"};
        double[] x_coordinates = {0.39, 0.72, 1.00, 1.52, -5.20};
        double[] y_coordinates = {0.24, 0.00, 0.00, 0.99, 2.86};
        double[] z_coordinates = {-0.10, 0.44, -0.02, 0.21, 0.42};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of a planet: ");
        String input = scanner.nextLine();

        int index = -1;
        for (int i = 0; i < planets.length; i++) {
            if (planets[i].equalsIgnoreCase(input)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Invalid input");
        } else {
            double minDistance = Double.MAX_VALUE;
            int closestPlanetIndex = -1;

            for (int i = 0; i < planets.length; i++) {
                if (i != index) {
                    double distance = Math.pow(x_coordinates[index] - x_coordinates[i], 2) +
                                      Math.pow(y_coordinates[index] - y_coordinates[i], 2) +
                                      Math.pow(z_coordinates[index] - z_coordinates[i], 2);
                    if (distance < minDistance) {
                        minDistance = distance;
                        closestPlanetIndex = i;
                    }
                }
            }

            System.out.println("Closest planet to " + input + " is " + planets[closestPlanetIndex] +
                               " with a distance of " + minDistance);
        }
    }
}
