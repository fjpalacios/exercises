# A simple code to practice recursion using the Factorial of a number (n!)


def main():
    while True:
        try:
            number_of_terms = int(input("Enter a number: "))
        except ValueError:
            print("Please, enter a positive integer")
            continue
        else:
            while number_of_terms < 0:
                print("Please, enter a positive integer")
                try:
                    number_of_terms = int(input("Enter a number: "))
                except ValueError:
                    continue
            value_factorial = factorial(number_of_terms)
            print("Factorial of", number_of_terms, "is", value_factorial)
            continue_program()


def factorial(number):
    if number <= 1:
        return 1
    return number * factorial(number-1)


def continue_program():
    system_exit = input("Do you want to continue with the program? [Y/n] ")
    if system_exit == "y" or system_exit == "":
        main()
    elif system_exit == "n":
        raise SystemExit
    else:
        print("You entered {}, but it is a wrong command. Good bye!"
              .format(exit))
        raise SystemExit


if __name__ == "__main__":
    main()
