import pytest
import isprime


@pytest.mark.parametrize("input, expected",
                         [
                          (7, True),
                          (69, False),
                          (73, True),
                          (156, False)
                         ]
                         )
def test_isPrime(input, expected):
    iP = isprime.isPrime(input)
    assert iP == expected


@pytest.mark.parametrize("input, expected",
                         [
                          (14, "2*7"),
                          (69, "3*23"),
                          (87, "3*29"),
                          (156, "2*2*3*13"),
                         ]
                         )
def test_primeFactors(input, expected):
    pF = isprime.primeFactors(input)
    assert pF == expected
