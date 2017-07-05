import pytest
import quadraticformula


@pytest.mark.parametrize("termA, termB, termC, expected",
                         [
                          (1, 5, 6, [-2, -3]),
                          (1, -5, 0, [0, 5]),
                          (1, 0, -25, [5, -5]),
                          (1, -2, 1, [1, 1]),
                          (2, 0, 8, [2, -2]),  # no real solution
                         ]
                         )
def test_quadraticFormula(termA, termB, termC, expected):
    qF = quadraticformula.QuadraticFormula(termA, termB, termC)
    assert qF.formula() == expected
