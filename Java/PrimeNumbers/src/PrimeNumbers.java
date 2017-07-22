// A simple code to practice printing a list of the first n prime numbers

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrimeNumbers {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            int numberOfPrimeNumbers = intGreaterThan0(
                    "How many prime numbers do you want to find out?: ", scan);
            System.out.printf("The first %d prime numbers are: %n",
                    numberOfPrimeNumbers);
            List<Integer> intList = primeNumbersGenerator(numberOfPrimeNumbers);
            String primeNumbers = intList.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));
            System.out.print(primeNumbers);
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
