# A simple code to practice OOP and Control Structures
# using the Collatz conjecture


class Collatz:
    def __init__(self, number):
        self.number = number

    def even_number(self):
        return int(self.number/2)

    def odd_number(self):
        return int(self.number*3 + 1)


def main():
    number = int_greather_than_0("Enter a number: ")
    while number > 1:
        collatz = Collatz(number)
        if number % 2 == 0:
            print("{} is even, dividing it by 2". format(number))
            number = collatz.even_number()
        else:
            print("{} is odd, multiplying it 3 times and adding 1"
                  .format(number))
            number = collatz.odd_number()
    print("In the end, the number obtained is {}".format(number))
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
