// A simple code to practice recursion using the Fibonacci Sequence

import java.util.Scanner;

public class Fibonacci {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            int numberOfTerms = intGreaterThan0("Enter how many terms of the "
                    + "Fibonacci sequence you want to find: ", scan);
            System.out.printf("The first %d terms of the Fibonacci sequence"
                    + " are: %n", numberOfTerms);
            for (int i = 0; i < numberOfTerms; i++) {
                System.out.print(fibonacci(i) + " ");
            }
            continueProgram(scan);
        }
    }

    private static int intGreaterThan0(String message, Scanner scan) {
        int intGreaterThan0 = 0;
        boolean integer = false;
        do {
            try {
                System.out.print(message);
                intGreaterThan0 = Integer.parseInt(scan.nextLine());
                integer = true;
            } catch (Exception e) {
                System.out.println("Please enter a positive integer.");
            }
            if (integer && intGreaterThan0 < 1) {
                System.out.println("Please enter a positive integer "
                        + "greater than 0.");
                integer = false;
            }
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
