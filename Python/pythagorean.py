# A simple code to practice Control Structures solving the missing side
# of a right triangle using the Pythagorean theorem

from math import sqrt


def main():
    leg_one = set_side("first leg")
    leg_two = set_side("second leg", leg_one)
    hypotenuse = set_side("hypotenuse", leg_one, leg_two)
    missing_side(leg_one, leg_two, hypotenuse)
    continue_program()


def set_side(side, leg_one=None, leg_two=None):
    while True:
        if leg_one == "x" or leg_two == "x":
            side_value = input("Enter {}: ".format(side))
        else:
            side_value = input("Enter {} (if it is the missing side enter x): "
                               .format(side))
        if side_value != "x":
            try:
                return float(side_value)
            except ValueError:
                print("Please, enter a proper value")
        elif side_value == "x" and leg_one != "x" and leg_two != "x":
            return side_value
        else:
            print("Please, enter a proper value")


def missing_side(leg_one, leg_two, hypotenuse):
    _missing_side = pythagorean(leg_one, leg_two, hypotenuse)
    if leg_one == "x":
        print("Leg one is: {0:.3f}".format(_missing_side))
    elif leg_two == "x":
        print("Leg two is: {0:.3f}".format(_missing_side))
    else:
        print("Hypotenuse is: {0:.3f}".format(_missing_side))


def pythagorean(leg_one, leg_two, hypotenuse):
    if leg_one == "x":
        _missing_side = sqrt((hypotenuse**2) - (leg_two**2))
        return _missing_side
    elif leg_two == "x":
        _missing_side = sqrt((hypotenuse**2) - (leg_one**2))
        return _missing_side
    _missing_side = sqrt((leg_one**2) + (leg_two**2))
    return _missing_side


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
