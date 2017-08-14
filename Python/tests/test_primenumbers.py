import pytest
import primenumbers


@pytest.mark.parametrize("result, expected",
                         [
                             (10, "2 3 5 7 11 13 17 19 23 29")
                         ])
def test_prime_numbers_generator(result, expected):
    _pn = primenumbers.prime_numbers_generator(result)
    assert _pn == expected


@pytest.mark.parametrize("result, expected",
                         [
                             (7, True),
                             (69, False),
                             (73, True),
                             (156, False)
                         ])
def test_is_prime(result, expected):
    _ip = primenumbers.is_prime(result)
    assert _ip == expected
