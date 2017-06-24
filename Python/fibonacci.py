# A simple code to practice recursion using the Fibonacci sequence

def fibonacci(number):
    if number <= 1:
        return 1
    else:
        return(fibonacci(number-1) + fibonacci(number-2))

while True:
    try:
        numberOfTerms = int(input("Enter how many terms of the Fibonacci " +
        "Sequence you want to find: "))
    except ValueError:
        print("Please, enter a positive integer greater than 0")
        continue
    else:
        while numberOfTerms <= 0:
            print("Please, enter a positive integer greater than 0")
            try:
                numberOfTerms = int(input("Enter how many terms of the " +
                "Fibonacci Sequence you want to find: "))
            except ValueError:
                continue
        print("The first {} terms of the Fibonacci Sequence are:" \
        .format(numberOfTerms))
        for i in range(numberOfTerms):
            print(fibonacci(i), end=" ")
        break
