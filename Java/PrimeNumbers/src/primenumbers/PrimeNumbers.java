// A simple code to practice printing a list of the first n prime numbers
package primenumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Javi Palacios <javi@fjp.es>
 */
public class PrimeNumbers {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            try {
                int numberOfPrimeNumbers = intGreaterThan0(
                        "How many prime numbers do you want to find out?: ", scan);
                System.out.printf("The first %d prime numbers are: %n",
                        numberOfPrimeNumbers);
                List<Integer> intList = primeNumbersGenerator(numberOfPrimeNumbers);
                String primeNumbers = integerListToString(intList);
                System.out.print(primeNumbers);
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

    public static List<Integer> primeNumbersGenerator(int numberOfPrimeNumbers) {
        List<Integer> primeFactors = new ArrayList<>();
        int count = 0;
        int number = 2;
        while (count < numberOfPrimeNumbers) {
            if (isPrime(number)) {
                primeFactors.add(number);
                count += 1;
            }
            number += 1;
        }
        return primeFactors;
    }

    public static String integerListToString(List<Integer> list) {
        String string = "";
        for (Integer integer : list) {
            string += String.format("%d ", integer);
        }
        return string;
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
