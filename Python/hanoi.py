# A simple code to practice recursion solving the game of the Tower of Hanoi

def main():
    while True:
        try:
            numberOfDisks = int(input("Enter a number of disks: "))
        except ValueError:
            print("In order to play enter one disk at least")
            continue
        else:
            while numberOfDisks <= 0:
                print("In order to play enter one disk at least")
                try:
                    numberOfDisks = int(input("Enter a number of disks: "))
                except ValueError:
                    continue
            numberOfMoves = 2**numberOfDisks - 1
            print("At least {} moves required to solve this game" \
            .format(numberOfMoves))
            hanoi(numberOfDisks, 1, 2, 3)
            continueProgram()

def hanoi(numberOfDisks, initialStack, auxiliarStack, finalStack):
    if numberOfDisks == 1:
        print("Moving disk {} from stack {} to stack {}" \
        .format(numberOfDisks, initialStack, finalStack))
    else:
        hanoi(numberOfDisks-1, initialStack, finalStack, auxiliarStack)
        print("Moving disk {} from stack {} to stack {}" \
        .format(numberOfDisks, initialStack, finalStack))
        hanoi(numberOfDisks-1, auxiliarStack, initialStack, finalStack)

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
