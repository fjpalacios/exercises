import pytest
import circle


@pytest.mark.parametrize("result, expected",
                         [
                             (4, 50.2654816),
                             (10, 314.15926)
                         ])
def test_area(result, expected):
    _c = circle.Circle(result)
    assert _c.area() == expected


@pytest.mark.parametrize("result, expected",
                         [
                             (4, 25.1327408),
                             (10, 62.831852),
                         ])
def test_perimeter(result, expected):
    _c = circle.Circle(result)
    assert _c.perimeter() == expected
