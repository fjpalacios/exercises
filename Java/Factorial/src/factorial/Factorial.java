// A simple code to practice recursion using the Factorial of a number (n!)
package factorial;

import java.util.Scanner;

/**
 *
 * @author Javi Palacios <javi@fjp.es>
 */
public class Factorial {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            try {
                int number = intGreaterThan0("Enter a possitive number: ", scan);
                double factorial = factorial(number);
                System.out.printf("Factorial of %d is %.0f", number, factorial);
                continueProgram(scan);
            } catch (NumberFormatException ex) {
                System.out.println("Please, enter a positive integer.");
            }
        }
    }

    public static double factorial(long number) {
        if (number <= 1) {
            return 1;
        } else {
            return (number * factorial(number - 1));
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
