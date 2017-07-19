/*
* A simple code to practice finding out if a number is prime or not
* If it is not a prime number, its prime factorization is printed
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IsPrime {

    private static boolean continueProgram = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (continueProgram) {
            int number = intGreaterThan0("Enter the number that you" +
                    " want to know if is a prime number: ", scan);
            boolean isPrimeNumber = isPrime(number);
            if (isPrimeNumber) {
                System.out.printf("%d is a prime number", number);
            } else {
                List<Integer> intList = primeFactors(number);
                String factorization = intList.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("*"));
                System.out.printf("%d is not a prime number (%s)", number,
                        factorization);
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
