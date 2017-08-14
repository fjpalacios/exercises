# A simple code to practice printing a list of the first n prime numbers


def main():
    while True:
        try:
            number_of_prime_numbers = int(
                input("How many prime numbers do you want to find out? "))
        except ValueError:
            print("Please, enter a positive integer greater than 0")
            continue
        else:
            while number_of_prime_numbers <= 0:
                print("Please, enter a positive integer greater than 0")
                try:
                    number_of_prime_numbers = int(
                        input("How many prime numbers do you want " +
                              "to find out? "))
                except ValueError:
                    continue
            print("The first {} prime numbers are:"
                  .format(number_of_prime_numbers))
            print(prime_numbers_generator(number_of_prime_numbers))
            continue_program()


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
    if system_exit == "y" or system_exit == "":
        main()
    elif system_exit == "n":
        raise SystemExit
    else:
        print("You entered {}, but it is a wrong command. Good bye!"
              .format(exit))
        raise SystemExit


if __name__ == "__main__":
    main()
