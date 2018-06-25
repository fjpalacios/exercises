# A simple code to practice recursion using the Factorial of a number (n!)


def main():
    number_of_terms = int_greather_than_0("Enter a possitive number: ")
    value_factorial = factorial(number_of_terms)
    print("Factorial of", number_of_terms, "is", value_factorial)
    continue_program()


def int_greather_than_0(message):
    while True:
        try:
            _int_greather_than_0 = int(input(message))
            if _int_greather_than_0 > 0:
                break
        except ValueError:
            print("Please, enter a positive integer greater than 0")
    return _int_greather_than_0


def factorial(number):
    if number <= 1:
        return 1
    return number * factorial(number-1)


def continue_program():
    system_exit = input("Do you want to continue with the program? [Y/n] ")
    system_exit = system_exit.lower()
    if system_exit == "y" or system_exit == "":
        main()
    elif system_exit == "n":
        raise SystemExit
    else:
        print("You entered {}, but it is a wrong command. Good bye!"
              .format(system_exit))
        raise SystemExit


if __name__ == "__main__":
    main()
