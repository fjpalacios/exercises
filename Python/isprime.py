# A simple code to practice finding out if a number is prime or not
# If it is not a prime number, its prime factorization is printed

def main():
    while True:
        try:
            number = int(input("Enter the number that you want to know if " +
            "is a prime number: "))
        except ValueError:
            print("Please, enter a positive integer greater than 0")
            continue
        else:
            while number <= 0:
                print("Please, enter a positive integer greater than 0")
                try:
                    number = int(input("Enter the number that you want to know" +
                    " if is a prime number: "))
                except ValueError:
                    continue
            isPrimeNumber = isPrime(number)
            if isPrimeNumber:
                print("{} is a prime number".format(number))
            else:
                print("{} is not a prime number ({})" \
                .format(number, primeFactors(number)))
            continueProgram()

def isPrime(number):
    for i in range(2, number):
        if number%i == 0:
            return False
    else:
        return True

def primeFactors(number):
    primeFactors = []
    for i in range(2, number):
        while number%i == 0:
            number = number/i
            primeFactors.append(i)
    return '*'.join(map(str,primeFactors))

def continueProgram():
    exit = input("Do you want to continue with the program? [Y/n] ")
    if exit == "y" or exit == "":
        main()
    elif exit == "n":
        raise SystemExit
    else:
        print("You entered {}, but it is a wrong command. Good bye!". format(exit))
        raise SystemExit

if __name__ == "__main__":
    main()
