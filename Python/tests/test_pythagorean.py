import pytest
import pythagorean


@pytest.mark.parametrize("leg_one, leg_two, hypotenuse, expected",
                         [
                             (5, 12, "x", 13),
                             (9, "x", 15, 12),
                             (3, 4, "x", 5),
                             (12, 16, "x", 20)
                         ])
def test_pythagorean(leg_one, leg_two, hypotenuse, expected):
    _p = pythagorean.pythagorean(leg_one, leg_two, hypotenuse)
    assert _p == expected
