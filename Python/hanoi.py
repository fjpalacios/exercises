# A simple code to practice recursion solving the game of the Tower of Hanoi


def main():
    number_of_disks = int_greather_than_0("Enter a number of disks: ")
    number_of_moves = 2**number_of_disks - 1
    print("At least {} moves required to solve this game"
          .format(number_of_moves))
    hanoi(number_of_disks, 1, 2, 3)
    continue_program()


def int_greather_than_0(message):
    while True:
        try:
            _int_greather_than_0 = int(input(message))
        except ValueError:
            print("Please, enter a positive integer greater than 0")
            continue
        else:
            while _int_greather_than_0 <= 0:
                print("Please, enter a positive integer greater than 0")
                try:
                    _int_greather_than_0 = int(input(message))
                except ValueError:
                    continue
            return _int_greather_than_0


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
