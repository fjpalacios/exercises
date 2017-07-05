import pytest
import fibonacci


@pytest.mark.parametrize("input, expected",
                         [
                          (0, 1),
                          (1, 1),
                          (4, 5),
                          (5, 8)
                         ]
                         )
def test_factorial(input, expected):
    f = fibonacci.fibonacci(input)
    assert f == expected
