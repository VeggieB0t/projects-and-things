#============================================
# Program: Simple Arithmetic in MIPS32
# Description: Performs (5 + 10) - 3
#============================================

.data
result_msg: .asciiz "Result: "

.text
.globl main
main:
    # Load numbers into registers
    li $t0, 8         # $t0 = 5
    li $t1, 10        # $t1 = 10
    li $t2, 3         # $t2 = 3

    # Perform addition
    add $t3, $t0, $t1 # $t3 = 5 + 10 = 15

    # Subtract
    sub $t4, $t3, $t2 # $t4 = 15 - 3 = 12

    # Print result message
    li $v0, 4
    la $a0, result_msg
    syscall

    # Print the result number
    li $v0, 1         # syscall 1 = print integer
    move $a0, $t4     # put result in $a0
    syscall

    # Newline
    li $v0, 11        # syscall 11 = print char
    li $a0, 10        # 10 = '\n'
    syscall

    # Exit
    li $v0, 10
    syscall
