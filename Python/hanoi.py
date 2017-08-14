# A simple code to practice recursion solving the game of the Tower of Hanoi


def main():
    while True:
        try:
            number_of_disks = int(input("Enter a number of disks: "))
        except ValueError:
            print("In order to play enter one disk at least")
            continue
        else:
            while number_of_disks <= 0:
                print("In order to play enter one disk at least")
                try:
                    number_of_disks = int(input("Enter a number of disks: "))
                except ValueError:
                    continue
            number_of_moves = 2**number_of_disks - 1
            print("At least {} moves required to solve this game"
                  .format(number_of_moves))
            hanoi(number_of_disks, 1, 2, 3)
            continue_program()


def hanoi(number_of_disks, initial_stack, auxiliar_stack, final_stack):
    if number_of_disks == 1:
        print("Moving disk {} from stack {} to stack {}"
              .format(number_of_disks, initial_stack, final_stack))
    else:
        hanoi(number_of_disks-1, initial_stack, final_stack, auxiliar_stack)
        print("Moving disk {} from stack {} to stack {}"
              .format(number_of_disks, initial_stack, final_stack))
        hanoi(number_of_disks-1, auxiliar_stack, initial_stack, final_stack)


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
