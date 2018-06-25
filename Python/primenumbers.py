# A simple code to practice printing a list of the first n prime numbers


def main():
    number_of_prime_numbers = int_greather_than_0(
        "How many prime numbers do you want to find out? ")
    print("The first {} prime numbers are:"
          .format(number_of_prime_numbers))
    print(prime_numbers_generator(number_of_prime_numbers))
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


def prime_numbers_generator(number_of_prime_numbers):
    prime_numbers = []
    count = 0
    number = 2
    while count < number_of_prime_numbers:
        if is_prime(number):
            prime_numbers.append(number)
            count += 1
        number += 1
    return " ".join(map(str, prime_numbers))


def is_prime(number):
    for i in range(2, number):
        if number % i == 0:
            return False
    return True


def continue_program():
    system_exit = input("Do you want to continue with the program? [Y/n] ")
    system_exit = system_exit.lower()
    if system_exit == "y" or system_exit == "":
        main()
    elif system_exit == "n":
        raise SystemExit
    else:
        print("You entered {}, but it is a wrong command. Good bye!"
              .format(system_exit))
        raise SystemExit


if __name__ == "__main__":
    main()
