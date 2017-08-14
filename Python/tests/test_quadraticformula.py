import pytest
import quadraticformula


@pytest.mark.parametrize("term_a, term_b, term_c, expected",
                         [
                             (1, 5, 6, [-2, -3]),
                             (1, -5, 0, [0, 5]),
                             (1, 0, -25, [5, -5]),
                             (1, -2, 1, [1, 1]),
                             (2, 0, 8, [2, -2]),  # no real solution
                         ])
def test_quadratic_formula(term_a, term_b, term_c, expected):
    _qf = quadraticformula.QuadraticFormula(term_a, term_b, term_c)
    assert _qf.formula() == expected
