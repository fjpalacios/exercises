# A simple code to practice printing a list of the first n prime numbers


def main():
    while True:
        try:
            numberOfPrimeNumbers = int(input("How many prime numbers " +
                                             "do you want to find out? "))
        except ValueError:
            print("Please, enter a positive integer greater than 0")
            continue
        else:
            while numberOfPrimeNumbers <= 0:
                print("Please, enter a positive integer greater than 0")
                try:
                    numberOfPrimeNumbers = int(input("How many prime numbers" +
                                                     " do you want " +
                                                     " to find out? "))
                except ValueError:
                    continue
            print("The first {} prime numbers are:"
                  .format(numberOfPrimeNumbers))
            print(primeNumbersGenerator(numberOfPrimeNumbers))
            continueProgram()


def primeNumbersGenerator(numberOfPrimeNumbers):
    primeNumbers = []
    count = 0
    number = 2
    while count < numberOfPrimeNumbers:
        if isPrime(number):
            primeNumbers.append(number)
            count += 1
        number += 1
    return " ".join(map(str, primeNumbers))


def isPrime(number):
    for i in range(2, number):
        if number % i == 0:
            return False
    else:
        return True


def continueProgram():
    exit = input("Do you want to continue with the program? [Y/n] ")
    if exit == "y" or exit == "":
        main()
    elif exit == "n":
        raise SystemExit
    else:
        print("You entered {}, but it is a wrong command. Good bye!"
              . format(exit))
        raise SystemExit


if __name__ == "__main__":
    main()
