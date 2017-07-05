import pytest
import pythagorean


@pytest.mark.parametrize("legOne, legTwo, hypotenuse, expected",
                         [
                          (5, 12, "x", 13),
                          (9, "x", 15, 12),
                          (3, 4, "x", 5),
                          (12, 16, "x", 20)
                         ]
                         )
def test_pythagorean(legOne, legTwo, hypotenuse, expected):
    p = pythagorean.pythagorean(legOne, legTwo, hypotenuse)
    assert p == expected
