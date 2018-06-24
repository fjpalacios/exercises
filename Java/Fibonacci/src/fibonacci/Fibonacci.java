// A simple code to practice recursion using the Fibonacci Sequence
package fibonacci;

import java.util.Scanner;

/**
 *
 * @author Javi Palacios <javi@fjp.es>
 */
public class Fibonacci {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            try {
                int numberOfTerms = intGreaterThan0("Enter how many terms of the "
                        + "Fibonacci sequence you want to find: ", scan);
                System.out.printf("The first %d terms of the Fibonacci sequence"
                        + " are: %n", numberOfTerms);
                for (int i = 0; i < numberOfTerms; i++) {
                    System.out.print(fibonacci(i) + " ");
                }
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

    public static long fibonacci(long number) {
        if (number <= 1) {
            return 1;
        } else {
            return (fibonacci(number - 1) + fibonacci(number - 2));
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
