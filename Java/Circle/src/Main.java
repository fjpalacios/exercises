// A simple code to practice solving the perimeter and area of a circle

import java.util.Scanner;

public class Main {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            int radius = intGreaterThan0("Enter a radius: ", scan);
            Circle circle = new Circle(radius);
            System.out.printf("The area of a circle with radius %d ≈ %.3f and "
                    + "its perimeter ≈ %.3f", radius, Circle.area(radius),
                    Circle.perimeter(radius));
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
