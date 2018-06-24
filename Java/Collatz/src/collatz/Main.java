// A simple code to practice Control Structures using the Collatz conjecture
package collatz;

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
                int number = intGreaterThan0("Enter a positive number: ", scan);
                conjecture(number);
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

    private static void conjecture(int number) {
        while (number > 1) {
            Collatz collatz = new Collatz(number);
            if (number % 2 == 0) {
                System.out.printf("%d is even, dividing it by 2 %n", number);
                number = collatz.evenNumber();
            } else {
                System.out.printf("%d is odd, multiplying it 3 times and adding 1 %n",
                        number);
                number = collatz.oddNumber();
            }
        }
        System.out.printf("In the end, the number obtained is %d", number);
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
