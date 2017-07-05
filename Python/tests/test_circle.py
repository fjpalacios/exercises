import pytest
import circle


@pytest.mark.parametrize("input, expected",
                         [
                          (4, 50.2654816),
                          (10, 314.15926)
                         ]
                         )
def test_area(input, expected):
    c = circle.Circle(input)
    assert c.area() == expected


@pytest.mark.parametrize("input, expected",
                         [
                          (4, 25.1327408),
                          (10, 62.831852),
                         ]
                         )
def test_perimeter(input, expected):
    c = circle.Circle(input)
    assert c.perimeter() == expected
