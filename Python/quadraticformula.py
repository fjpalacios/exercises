'''A simple code to practice OOP & Control Structures solving an equation like
ax^2+bx+c (degree two) using the quadratic formula.
There are conditionals (if) which use another way to solve it
when the equation is incomplete (it has no b or c terms)'''


from math import sqrt
from decimal import Decimal


class QuadraticFormula:
    def __init__(self, term_a, term_b, term_c):
        self.term_a = term_a
        self.term_b = term_b
        self.term_c = term_c

    def get_discriminant(self):
        return self.term_b**2-4*self.term_a*self.term_c

    def get_root(self):
        root = self.formula()
        print("Solution: {}".format(Decimal(root[0]).normalize()))

    def get_roots(self):
        roots = self.formula()
        print("Solution one: {}".format(Decimal(roots[0]).normalize()))
        print("Solution two: {}".format(Decimal(roots[1]).normalize()))

    def formula(self):
        solutions = []
        if self.term_b == 0:
            if self.term_a < 0:
                self.term_a = -(self.term_a)
            elif self.term_c < 0:
                self.term_c = -(self.term_c)
            solution_one = sqrt(self.term_c/self.term_a)
            solution_two = -(solution_one)
            solutions.append(solution_one)
            solutions.append(solution_two)
        elif self.term_c == 0:
            solution_one = 0
            solution_two = -(self.term_b)/self.term_a
            solutions.append(solution_one)
            solutions.append(solution_two)
        else:
            solution_one = ((-self.term_b+sqrt(self.get_discriminant()))
                            / (2*self.term_a))
            solution_two = ((-self.term_b-sqrt(self.get_discriminant()))
                            / (2*self.term_a))
            solutions.append(solution_one)
            solutions.append(solution_two)
        return solutions

    def solve(self):
        if self.get_discriminant() > 0:
            self.get_roots()
        elif self.get_discriminant() == 0:
            self.get_root()
        else:
            print("This equation has no real numbers solution")


def main():
    term_a = set_side("a")
    term_b = set_side("b")
    term_c = set_side("c", term_b)
    equation = QuadraticFormula(term_a, term_b, term_c)
    equation.solve()
    continue_program()


def set_side(term, term_b=None):
    while True:
        if term == "a" or term_b == 0:
            term_value = input("Enter value for {}: ".format(term))
        else:
            term_value = input("Enter value for {0} (if this equation has "
                               "no term {0} enter 0): ".format(term))
        if term_value == "0" and term != "a" and term_b != 0:
            return 0
        elif term_value != "0":
            try:
                return float(term_value)
            except ValueError:
                print("Please, enter a proper value")
        else:
            print("Please, enter a proper value")


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
