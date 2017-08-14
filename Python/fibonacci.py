# A simple code to practice recursion using the Fibonacci Sequence


def main():
    number_of_terms = int_greather_than_0(
        "Enter how many terms of the Fibonacci Sequence you want to find: ")
    print("The first {} terms of the Fibonacci Sequence are:"
          .format(number_of_terms))
    for i in range(number_of_terms):
        print(fibonacci(i), end=" ")
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


def fibonacci(number):
    if number <= 1:
        return 1
    return fibonacci(number-1) + fibonacci(number-2)


def continue_program():
    system_exit = input("\nDo you want to continue with the program? [Y/n] ")
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
