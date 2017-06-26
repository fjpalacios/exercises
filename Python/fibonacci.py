# A simple code to practice recursion using the Fibonacci Sequence


def fibonacci(number):
    if number <= 1:
        return 1
    else:
        return(fibonacci(number-1) + fibonacci(number-2))


def continueProgram():
    exit = input("\nDo you want to continue with the program? [Y/n] ")
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
            numberOfTerms = int(input("Enter how many terms of the Fibonacci "
                                      + "Sequence you want to find: "))
        except ValueError:
            print("Please, enter a positive integer greater than 0")
            continue
        else:
            while numberOfTerms <= 0:
                print("Please, enter a positive integer greater than 0")
                try:
                    numberOfTerms = int(input("Enter how many terms of the " +
                                              "Fibonacci Sequence " +
                                              "you want to find: "))
                except ValueError:
                    continue
            print("The first {} terms of the Fibonacci Sequence are:"
                  .format(numberOfTerms))
            for i in range(numberOfTerms):
                print(fibonacci(i), end=" ")
            continueProgram()


if __name__ == "__main__":
    main()
