/*
 * A simple code to practice OOP & Control Structures solving an equation like
 * ax^2+bx+c (degree two) using the quadratic formula.
 * There are conditionals (if) which use another way to solve it
 * when the equation is incomplete (it has no b or c terms)
 */
package quadraticformula;

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
            float termA = setSide("a", scan);
            float termB = setSide("b", scan);
            float termC = setSide(termB, scan);
            QuadraticFormula equation = new QuadraticFormula(termA, termB, termC);
            equation.solve();
            continueProgram(scan);
        }
    }

    private static float setSide(String side, Scanner scan) {
        if (side.equalsIgnoreCase("a")) {
            return getNumber("Enter value for a: ", false, scan);
        }
        return getNumber("Enter value for b ("
                + "if this equation has no b term enter 0): ", true, scan);
    }

    private static float setSide(float termB, Scanner scan) {
        if (termB == 0) {
            return getNumber("Enter value for c: ", false, scan);
        }
        return getNumber("Enter value for c ("
                + "if this equation has no c term enter 0): ", true, scan);
    }

    private static float getNumber(String message, boolean canBeZero, Scanner scan) {
        float number = 0;
        boolean validNumber = false;
        do {
            try {
                System.out.print(message);
                number = Float.parseFloat(scan.nextLine());
                validNumber = true;
            } catch (NumberFormatException ex) {
                System.out.println("Please, enter only numbers.");
            }
        } while ((!canBeZero && number == 0) || !validNumber);
        return number;
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
