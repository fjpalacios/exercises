# A simple code to practice OOP and Control Structures
# using the Collatz conjecture


class Collatz:
    def __init__(self, number):
        self.number = number

    def evenNumber(self):
        return int(self.number/2)

    def oddNumber(self):
        return int(self.number*3 + 1)


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
            number = int(input("Enter a number: "))
        except ValueError:
            print("Please, enter a positive integer greater than 0")
            continue
        else:
            while number <= 0:
                print("Please, enter a positive integer greater than 0")
                try:
                    number = int(input("Enter a number: "))
                except ValueError:
                    continue
            while number > 1:
                collatz = Collatz(number)
                if number % 2 == 0:
                    print("{} is even, dividing it by 2". format(number))
                    number = collatz.evenNumber()
                else:
                    print("{} is odd, multiplying it 3 times and adding 1"
                          .format(number))
                    number = collatz.oddNumber()
            else:
                print("In the end, the number obtained is {}".format(number))
            continueProgram()


if __name__ == "__main__":
    main()
