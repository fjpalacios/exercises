'''A simple code to practice OOP & Control Structures solving an equation like
ax^2+bx+c (degree two) using the quadratic formula.
There are conditionals (if) which use another way to solve it
when the equation is incomplete (it has no b or c terms)'''


from math import sqrt
from decimal import Decimal


class QuadraticFormula:
    def __init__(self, termA, termB, termC):
        self.termA = termA
        self.termB = termB
        self.termC = termC

    def getDiscriminant(self):
        return self.termB**2-4*self.termA*self.termC

    def getRoot(self):
        root = self.formula()
        print("Solution: {}".format(Decimal(root[0]).normalize()))

    def getRoots(self):
        roots = self.formula()
        print("Solution one: {}".format(Decimal(roots[0]).normalize()))
        print("Solution two: {}".format(Decimal(roots[1]).normalize()))

    def formula(self):
        solutions = []
        if self.termB == "x":
            if self.termA < 0:
                self.termA = -(self.termA)
            elif self.termC < 0:
                self.termC = -(self.termC)
            solutionOne = sqrt(self.termC/self.termA)
            solutionTwo = -(solutionOne)
            solutions.append(solutionOne)
            solutions.append(solutionTwo)
        elif self.termC == "x":
            solutionOne = 0
            solutionTwo = -(self.termB)/self.termA
            solutions.append(solutionOne)
            solutions.append(solutionTwo)
        else:
            solutionOne = ((-self.termB+sqrt(self.getDiscriminant()))
                           / (2*self.termA))
            solutionTwo = ((-self.termB-sqrt(self.getDiscriminant()))
                           / (2*self.termA))
            solutions.append(solutionOne)
            solutions.append(solutionTwo)
        return solutions

    def solve(self):
        if self.getDiscriminant() > 0:
            self.getRoots()
        elif self.getDiscriminant() == 0:
            self.getRoot()
        else:
            print("This equation has no real numbers solution")


def setSide(term, termA=None, termB=None):
    while True:
        if term == "a" or termB == 0:
            termValue = input("Enter value for {}: ".format(term))
        else:
            termValue = input("Enter value for {0} (if this equation has "
                              "no term {0} enter 0): "
                              .format(term))
        if termValue == "0" and term != "a" and termB != 0:
            return 0
            break
        elif termValue != "0":
            try:
                return float(termValue)
                break
            except ValueError:
                print("Please, enter a proper value")
        else:
            print("Please, enter a proper value")


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
    termA = setSide("a")
    termB = setSide("b", termA)
    termC = setSide("c", termA, termB)
    equation = QuadraticFormula(termA, termB, termC)
    equation.solve()
    continueProgram()


if __name__ == "__main__":
    main()
