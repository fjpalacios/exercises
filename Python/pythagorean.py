# A simple code to practice Control Structures solving the missing side
# of a right triangle using the Pythagorean theorem


from math import sqrt
from decimal import Decimal


def main():
    legOne = setSide("first leg")
    legTwo = setSide("second leg", legOne)
    hypotenuse = setSide("hypotenuse", legOne, legTwo)
    missingSide(legOne, legTwo, hypotenuse)
    continueProgram()


def setSide(side, legOne=None, legTwo=None):
    while True:
        if legOne == "x" or legTwo == "x":
            sideValue = input("Enter {}: ".format(side))
        else:
            sideValue = input("Enter {} (if it is the missing side enter x): "
                              .format(side))
        if sideValue != "x":
            try:
                return float(sideValue)
                break
            except ValueError:
                print("Please, enter a proper value")
        elif sideValue == "x" and legOne != "x" and legTwo != "x":
            return sideValue
            break
        else:
            print("Please, enter a proper value")


def missingSide(legOne, legTwo, hypotenuse):
    missingSide = pythagorean(legOne, legTwo, hypotenuse)
    if legOne == "x":
        print("Leg one is: {}".format(Decimal(missingSide).normalize()))
    elif legTwo == "x":
        print("Leg two is: {}".format(Decimal(missingSide).normalize()))
    else:
        print("Hypotenuse is: {}".format(Decimal(missingSide).normalize()))


def pythagorean(legOne, legTwo, hypotenuse):
    if legOne == "x":
        missingSide = sqrt((hypotenuse**2) - (legTwo**2))
        return missingSide
    elif legTwo == "x":
        missingSide = sqrt((hypotenuse**2) - (legOne**2))
        return missingSide
    else:
        missingSide = sqrt((legOne**2) + (legTwo**2))
        return missingSide


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


if __name__ == "__main__":
    main()
