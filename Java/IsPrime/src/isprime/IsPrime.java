/*
* A simple code to practice finding out if a number is prime or not
* If it is not a prime number, its prime factorization is printed
 */
package isprime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Javi Palacios <javi@fjp.es>
 */
public class IsPrime {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            try {
                int number = intGreaterThan0("Enter the number that you"
                        + " want to know if is a prime number: ", scan);
                if (isPrime(number)) {
                    System.out.printf("%d is a prime number", number);
                } else {
                    List<Integer> intList = primeFactors(number);
                    String factorization = factorization(intList);
                    System.out.printf("%d is not a prime number (%s)", number,
                            factorization);
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

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> primeFactors(int number) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                number = number / i;
                primeFactors.add(i);
            }
        }
        return primeFactors;
    }

    public static String factorization(List<Integer> list) {
        String string = "";
        for (Integer integer : list) {
            string += String.format("%d*", integer);
        }
        return string.substring(0, string.length() - 1);
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
