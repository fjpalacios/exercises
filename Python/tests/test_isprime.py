import pytest
import isprime


@pytest.mark.parametrize("result, expected",
                         [
                             (7, True),
                             (69, False),
                             (73, True),
                             (156, False)
                         ])
def test_is_prime(result, expected):
    _ip = isprime.is_prime(result)
    assert _ip == expected


@pytest.mark.parametrize("result, expected",
                         [
                             (14, "2*7"),
                             (69, "3*23"),
                             (87, "3*29"),
                             (156, "2*2*3*13"),
                         ])
def test_prime_factors(result, expected):
    _pf = isprime.prime_factors(result)
    assert _pf == expected
