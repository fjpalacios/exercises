package quadraticformula;

import java.util.ArrayList;
import java.util.List;

public class QuadraticFormula {

    private float termA, termB, termC;

    public QuadraticFormula(float termA, float termB, float termC) {
        this.termA = termA;
        this.termB = termB;
        this.termC = termC;
    }

    private double getDiscriminant() {
        return Math.pow(this.termB, 2) - 4 * this.termA * this.termC;
    }

    private void getRoot() {
        List<Double> roots = this.formula();
        System.out.printf(String.format("Solution: %s", roots.get(0)));
    }

    private void getRoots() {
        List<Double> roots = this.formula();
        System.out.printf(String.format("Solution one: %s%n", roots.get(0)));
        System.out.printf(String.format("Solution two: %s", roots.get(1)));
    }

    public List<Double> formula() {
        List<Double> solutions = new ArrayList<>();
        double solutionOne, solutionTwo;
        if (this.termB == 0) {
            if (this.termA < 0) {
                this.termA = -(this.termA);
            } else if (this.termC < 0) {
                this.termC = -(this.termC);
            }
            solutionOne = Math.sqrt(this.termC / this.termA);
            solutionTwo = -(solutionOne);
            solutions.add(solutionOne);
            solutions.add(solutionTwo);
        } else if (this.termC == 0) {
            solutionOne = 0;
            solutionTwo = -(this.termB) / this.termA;
            solutions.add(solutionOne);
            solutions.add(solutionTwo);
        } else {
            solutionOne = ((-this.termB + Math.sqrt(this.getDiscriminant()))
                    / (2 * this.termA));
            solutionTwo = ((-this.termB - Math.sqrt(this.getDiscriminant()))
                    / (2 * this.termA));
            solutions.add(solutionOne);
            solutions.add(solutionTwo);
        }
        return solutions;
    }

    void solve() {
        if (this.getDiscriminant() > 0) {
            this.getRoots();
        } else if (this.getDiscriminant() == 0) {
            this.getRoot();
        } else {
            System.out.print("This equation has no real numbers solution");
        }
    }

}
