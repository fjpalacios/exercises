// A simple code to practice solving the perimeter and area of a circle
package circle;

import java.util.Scanner;

/**
 *
 * @author Javi Palacios <javi@fjp.es>
 */
public class Main {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            try {
                int radius = intGreaterThan0("Enter a possitive radius: ", scan);
                Circle circle = new Circle(radius);
                System.out.printf("The area of a circle with radius %d ≈ %.3f and "
                        + "its perimeter ≈ %.3f", radius, Circle.area(radius),
                        Circle.perimeter(radius));
                continueProgram(scan);
            } catch (NumberFormatException ex) {
                System.out.println("Please, enter a positive integer.");
            }
        }
    }

    private static int intGreaterThan0(String message, Scanner scan)
            throws NumberFormatException {
        int intGreaterThan0 = 0;
        do {
            System.out.print(message);
            intGreaterThan0 = Integer.parseInt(scan.nextLine());
        } while (intGreaterThan0 < 1);
        return intGreaterThan0;
    }

    private static void continueProgram(Scanner scan) {
        System.out.print("\nDo you want to continue with the program? [Y/n] ");
        String exit = scan.nextLine();
        if ("y".equalsIgnoreCase(exit) || "".equals(exit)) {
            continueProgram = true;
        } else if ("n".equalsIgnoreCase(exit)) {
            continueProgram = false;
        } else {
            System.out.println("You entered a wrong command. Good bye!");
            continueProgram = false;
        }
    }

}
