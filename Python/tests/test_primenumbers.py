import pytest
import primenumbers


@pytest.mark.parametrize("input, expected",
                         [
                          (10, "2 3 5 7 11 13 17 19 23 29")
                         ]
                         )
def test_primeNumbersGenerator(input, expected):
    pN = primenumbers.primeNumbersGenerator(input)
    assert pN == expected


@pytest.mark.parametrize("input, expected",
                         [
                          (7, True),
                          (69, False),
                          (73, True),
                          (156, False)
                         ]
                         )
def test_isPrime(input, expected):
    iP = primenumbers.isPrime(input)
    assert iP == expected
