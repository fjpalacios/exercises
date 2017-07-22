// A simple code to practice recursion solving the game of the Tower of Hanoi

import java.util.Scanner;

public class Hanoi {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            int numberOfDisks = intGreaterThan0("Enter a number of disks: ", scan);
            int numberOfMoves = (int) (Math.pow(2, numberOfDisks) - 1);
            System.out.printf("At least %d moves required to solve this game %n",
                    numberOfMoves);
            hanoi(numberOfDisks, 1, 2, 3);
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

    private static void hanoi(int numberOfDisks, int initialStack, int auxiliarStack, int finalStack) {
        if (numberOfDisks == 1) {
            System.out.printf("Moving disk %d from stack %d to stack %d%n",
                    numberOfDisks, initialStack, finalStack);
        } else {
            hanoi(numberOfDisks-1, initialStack, finalStack, auxiliarStack);
            System.out.printf("Moving disk %d from stack %d to stack %d%n",
                    numberOfDisks, initialStack, finalStack);
            hanoi(numberOfDisks-1, auxiliarStack, initialStack, finalStack);
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
