import pytest
import factorial


@pytest.mark.parametrize("input, expected",
                         [
                          (6, 720),
                          (7, 5040),
                          (8, 40320),
                          (9, 362880),
                          (10, 3628800)
                         ]
                         )
def test_factorial(input, expected):
    f = factorial.factorial(input)
    assert f == expected
