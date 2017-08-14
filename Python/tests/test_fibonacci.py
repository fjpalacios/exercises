import pytest
import fibonacci


@pytest.mark.parametrize("result, expected",
                         [
                             (0, 1),
                             (1, 1),
                             (4, 5),
                             (5, 8)
                         ])
def test_factorial(result, expected):
    _f = fibonacci.fibonacci(result)
    assert _f == expected
