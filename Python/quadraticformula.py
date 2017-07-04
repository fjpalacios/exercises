'''A simple code to practice Control Structures solving an equation like
ax^2+bx+c (degree two) using the quadratic formula.
There are conditionals (if) which use another way to solve it
when the equation is incomplete (it has no b or c terms)'''


from math import sqrt
from decimal import Decimal


def main():
    termA = setSide("a")
    termB = setSide("b", termA)
    termC = setSide("c", termA, termB)
    quadraticFormula(termA, termB, termC)
    continueProgram()


def setSide(term, termA=None, termB=None):
    while True:
        if term == "a" or termB == "x":
            termValue = input("Enter value for {}: ".format(term))
        else:
            termValue = input("Enter value for {0} (if this equation has "
                              "no term {0} enter x): "
                              .format(term))
        if termValue != "x":
            try:
                return float(termValue)
                break
            except ValueError:
                print("Please, enter a proper value")
        elif termValue == "x" and term != "a" and termB != "x":
            return termValue
            break
        else:
            print("Please, enter a proper value")


def getDiscriminant(termA, termB, termC):
    return termB**2-4*termA*termC


def quadraticFormula(termA, termB, termC):
    if getDiscriminant(termA, termB, termC) >= 0:
        if termB == "x":
            if termA < 0:
                termA = -(termA)
            elif termC < 0:
                termC = -(termC)
            solutionOne = sqrt(termC/termA)
            solutionTwo = -(solutionOne)
            print("Solution one: {}".format(Decimal(solutionOne).normalize()))
            print("Solution two: {}".format(Decimal(solutionTwo).normalize()))
        elif termC == "x":
            solutionOne = 0
            solutionTwo = -(termB)/termA
            print("Solution one: {}".format(Decimal(solutionOne).normalize()))
            print("Solution two: {}".format(Decimal(solutionTwo).normalize()))
        else:
            solutionOne = ((-termB+sqrt(getDiscriminant(termA, termB, termC)))
                           / (2*termA))
            solutionTwo = ((-termB-sqrt(getDiscriminant(termA, termB, termC)))
                           / (2*termA))
            print("Solution one: {}".format(Decimal(solutionOne).normalize()))
            print("Solution two: {}".format(Decimal(solutionTwo).normalize()))
    else:
        print("This equation has no real solutions")


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
