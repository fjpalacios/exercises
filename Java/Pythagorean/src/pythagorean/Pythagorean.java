/* A simple code to practice Control Structures solving the missing side
 * of a right triangle using the Pythagorean theorem
 */
package pythagorean;

import java.util.Scanner;

/**
 *
 * @author Javi Palacios <javi@fjp.es>
 */
public class Pythagorean {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            float legOne = setSide(scan);
            float legTwo = setSide(legOne, scan);
            float hypotenuse = setSide(legOne, legTwo, scan);
            missingSide(legOne, legTwo, hypotenuse);
            continueProgram(scan);
        }
    }

    private static float setSide(Scanner scan) {
        return getPossitiveNumberOrZero("Enter leg one ("
                + "if it is the missing side enter 0): ", true, scan);
    }

    private static float setSide(float legOne, Scanner scan) {
        if (legOne == 0) {
            return getPossitiveNumberOrZero("Enter leg two: ", false, scan);
        }
        return getPossitiveNumberOrZero("Enter leg two ("
                + "if it is the missing side enter 0): ", true, scan);
    }

    private static float setSide(float legOne, float legTwo, Scanner scan) {
        if (legOne == 0 || legTwo == 0) {
            return getPossitiveNumberOrZero("Enter hypotenuse: ", false, scan);
        }
        return 0;
    }

    private static float getPossitiveNumberOrZero(String message,
            boolean canBeZero, Scanner scan) {
        float number = -1;
        do {
            try {
                System.out.print(message);
                number = Float.parseFloat(scan.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Please, enter only numbers.");
            }
        } while ((canBeZero && number == -1) || (!canBeZero && number < 1));
        return number;
    }

    private static void missingSide(float legOne, float legTwo, float hypotenuse) {
        double missingSide = pythagorean(legOne, legTwo, hypotenuse);
        if (legOne == 0) {
            System.out.printf(String.format("Leg one is: %.3f", missingSide));
        } else if (legTwo == 0) {
            System.out.printf(String.format("Leg two is: %.3f", missingSide));
        } else {
            System.out.printf(String.format("Hypotenuse is: %.3f", missingSide));
        }
    }

    public static double pythagorean(float legOne, float legTwo, float hypotenuse) {
        if (legOne == 0) {
            return Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(legTwo, 2));
        } else if (legTwo == 0) {
            return Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(legOne, 2));
        } else {
            return Math.sqrt(Math.pow(legOne, 2) + Math.pow(legTwo, 2));
        }
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
