# A simple code to practice solving the perimeter and the area of a circle


class Circle:
    pi = 3.1415926

    def __init__(self, radius):
        self.radius = radius

    def area(self):
        return Circle.pi * self.radius**2

    def perimeter(self):
        return 2 * Circle.pi * self.radius


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
            number = int(input("Enter a radius: "))
        except ValueError:
            print("Please, enter a positive integer greater than 0")
            continue
        else:
            while number <= 0:
                print("Please, enter a positive integer greater than 0")
                try:
                    number = int(input("Enter a radius: "))
                except ValueError:
                    continue
            circle = Circle(number)
            print("The area of a circle with radius {} is {}" +
                  " and its perimeter is {}"
                  .format(number, circle.area(), circle.perimeter()))
            continueProgram()


if __name__ == "__main__":
    main()
