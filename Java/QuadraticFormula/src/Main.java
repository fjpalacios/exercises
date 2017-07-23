/*
 * A simple code to practice OOP & Control Structures solving an equation like
 * ax^2+bx+c (degree two) using the quadratic formula.
 * There are conditionals (if) which use another way to solve it
 * when the equation is incomplete (it has no b or c terms)
 */

import java.util.Scanner;

public class Main {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            float termA = setSide("a", scan);
            float termB = setSide("b", scan);
            float termC = setSide(termB, scan);
            QuadraticFormula equation = new QuadraticFormula(termA, termB, termC);
            equation.solve();
            continueProgram(scan);
        }
    }

    private static float setSide(String side, Scanner scan) {
        if (side.equals("a")) {
            return number("Enter value for a: ", false, scan);
        } else {
            return number("Enter value for b (" +
                    "if this equation has no b term enter 0): ", true, scan);
        }
    }

    private static float setSide(float termB, Scanner scan) {
        if (termB == 0) {
            return number("Enter value for c: ", false, scan);
        } else {
            return number("Enter value for c (" +
                    "if this equation has no c term enter 0): ", true, scan);
        }
    }

    private static float number(String message, boolean missing, Scanner scan) {
        float number = 0;
        boolean scanNumber = false;
        while (!scanNumber) {
            try {
                System.out.print(message);
                number = Float.parseFloat(scan.nextLine());
                if (missing == false && number == 0) {
                    throw new Exception();
                } else {
                    scanNumber = true;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number.");
            }
        }
        return number;
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
