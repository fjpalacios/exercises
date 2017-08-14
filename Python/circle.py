# A simple code to practice solving the perimeter and the area of a circle


class Circle:
    _pi = 3.1415926

    def __init__(self, radius):
        self.radius = radius

    def area(self):
        return Circle._pi * self.radius**2

    def perimeter(self):
        return 2 * Circle._pi * self.radius


def main():
    number = int_greather_than_0("Enter a radius: ")
    circle = Circle(number)
    print("The area of a circle with radius {} is {} "
          "and its perimeter is {}"
          .format(number, circle.area(), circle.perimeter()))
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
