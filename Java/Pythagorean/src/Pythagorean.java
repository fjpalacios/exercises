/* A simple code to practice Control Structures solving the missing side
 * of a right triangle using the Pythagorean theorem
 */

import java.text.DecimalFormat;
import java.util.Scanner;

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
        return numberGreaterThan0("Enter leg one (" +
                "if it is the missing side enter 0): ", true, scan);
    }

    private static float setSide(float legOne, Scanner scan) {
        if (legOne == 0) {
            return numberGreaterThan0("Enter leg two: ", false, scan);
        } else {
            return numberGreaterThan0("Enter leg two (" +
                    "if it is the missing side enter 0): ", true, scan);
        }
    }

    private static float setSide(float legOne, float legTwo, Scanner scan) {
        if (legOne == 0 || legTwo == 0) {
            return numberGreaterThan0("Enter hypotenuse: ", false, scan);
        } else {
            return 0;
        }
    }

    private static float numberGreaterThan0(String message, boolean missing, Scanner scan) {
        float number = 0;
        boolean scanNumber = false;
        while (!scanNumber) {
            do {
                try {
                    System.out.print(message);
                    number = Float.parseFloat(scan.nextLine());
                    if (missing == false && number == 0) {
                        throw new Exception();
                    } else {
                        scanNumber = true;
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a positive number.");
                }
                if (scanNumber && number < 0) {
                    System.out.println("Please enter a positive number.");
                    scanNumber = false;
                }
            } while (number < 0);
        }
        return number;
    }

    private static void missingSide(float legOne, float legTwo, float hypotenuse) {
        double missingSide = pythagorean(legOne, legTwo, hypotenuse);
        DecimalFormat decimal = new DecimalFormat("0.###");
        if (legOne == 0) {
            System.out.printf("Leg one is: %s", decimal.format(missingSide));
        } else if (legTwo == 0) {
            System.out.printf("Leg two is: %s", decimal.format(missingSide));
        } else {
            System.out.printf("Hypotenuse is: %s", decimal.format(missingSide));
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
        if ("y".equals(exit) || "".equals(exit)) {
            continueProgram = true;
        } else if ("n".equals(exit)) {
            continueProgram = false;
        } else {
            System.out.println("You entered a wrong command. Good bye!");
            continueProgram = false;
        }
    }

}
