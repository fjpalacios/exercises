# A simple code to practice recursion using the Factorial of a number (n!)


def main():
    number_of_terms = int_greather_than_0("Enter a number: ")
    value_factorial = factorial(number_of_terms)
    print("Factorial of", number_of_terms, "is", value_factorial)
    continue_program()


def int_greather_than_0(message):
    while True:
        try:
            _int_greather_than_0 = int(input(message))
        except ValueError:
            print("Please, enter a positive integer greater than 0")
            continue
        else:
            while _int_greather_than_0 <= 0:
                print("Please, enter a positive integer greater than 0")
                try:
                    _int_greather_than_0 = int(input(message))
                except ValueError:
                    continue
            return _int_greather_than_0


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
