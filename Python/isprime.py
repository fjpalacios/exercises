# A simple code to practice finding out if a number is prime or not
# If it is not a prime number, its prime factorization is printed


def main():
    number = int_greather_than_0(
        "Enter the number that you want to know if is a prime number: ")
    is_prime_number = is_prime(number)
    if is_prime_number:
        print("{} is a prime number".format(number))
    else:
        print("{} is not a prime number ({})"
              .format(number, prime_factors(number)))
    continue_program()


def int_greather_than_0(message):
    while True:
        try:
            _int_greather_than_0 = int(input(message))
            if _int_greather_than_0 > 0:
                break
        except ValueError:
            print("Please, enter a positive integer greater than 0")
    return _int_greather_than_0


def is_prime(number):
    for i in range(2, number):
        if number % i == 0:
            return False
    return True


def prime_factors(number):
    _prime_factors = []
    for i in range(2, number):
        while number % i == 0:
            number = number / i
            _prime_factors.append(i)
    return '*'.join(map(str, _prime_factors))


def continue_program():
    system_exit = input("Do you want to continue with the program? [Y/n] ")
    system_exit = system_exit.lower()
    if system_exit == "y" or system_exit == "":
        main()
    elif system_exit == "n":
        raise SystemExit
    else:
        print("You entered {}, but it is a wrong command. Good bye!"
              . format(system_exit))
        raise SystemExit


if __name__ == "__main__":
    main()
