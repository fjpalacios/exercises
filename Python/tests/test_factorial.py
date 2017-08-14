import pytest
import factorial


@pytest.mark.parametrize("result, expected",
                         [
                             (6, 720),
                             (7, 5040),
                             (8, 40320),
                             (9, 362880),
                             (10, 3628800)
                         ])
def test_factorial(result, expected):
    _f = factorial.factorial(result)
    assert _f == expected
