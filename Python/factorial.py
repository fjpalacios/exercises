# A simple code to practice recursion using the Factorial of a number (n!)


def factorial(number):
    factorial = 1
    while number > 0:
        factorial = factorial * number
        number -= 1
    return factorial


def continueProgram():
    exit = input("Do you want to continue with the program? [Y/n] ")
    if exit == "y" or exit == "":
        main()
    elif exit == "n":
        raise SystemExit
    else:
        print("You entered {}, but it is a wrong command. Good bye!"
              .format(exit))
        raise SystemExit


def main():
    while True:
        try:
            numberOfTerms = int(input("Enter a number: "))
        except ValueError:
            print("Please, enter a positive integer")
            continue
        else:
            while numberOfTerms < 0:
                print("Please, enter a positive integer")
                try:
                    numberOfTerms = int(input("Enter a number: "))
                except ValueError:
                    continue
            valueFactorial = factorial(numberOfTerms)
            print("Factorial of", numberOfTerms, "is", valueFactorial)
            continueProgram()


if __name__ == "__main__":
    main()
