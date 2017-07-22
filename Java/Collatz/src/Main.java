// A simple code to practice OOP and Control Structures using the Collatz conjecture

import java.util.Scanner;

public class Main {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            int number = intGreaterThan0("Enter a positive number: ", scan);
            conjecture(number);
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
