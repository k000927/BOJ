import sys

zero = 0
sudoku = []
for i in range(9):
    line = list(map(int, sys.stdin.readline().split()))
    sudoku += line

for i in range(81):
    if sudoku[i] == 0:
        zero += 1


def printSudoku(sudoku):
    for i in range(9):
        string = ""
        for j in range(9):
            string += str(sudoku[i * 9 + j])
            string += " "
        print(string)


def columnCheck(idx, num):
    startIdx = idx % 9
    for i in range(startIdx, startIdx + 81, 9):
        if sudoku[i] == num:
            return False
    return True


def rowCheck(idx, num):
    startIdx = idx // 9 * 9
    for i in range(startIdx, startIdx + 9):
        if sudoku[i] == num:
            return False
    return True


def boxCheck(idx, num):
    i = (idx // 9) // 3 * 3
    j = idx % 9 // 3 * 3
    for x in range(3):
        for y in range(3):
            if num == sudoku[(i + x) * 9 + j + y]:
                return False
    return True


def backTracking(idx, sudoku, zero):
    if zero == 0:
        printSudoku(sudoku)
        exit()
    elif sudoku[idx] != 0:
        backTracking(idx + 1, sudoku, zero)
    else:
        for i in range(1, 10):
            if columnCheck(idx, i) and boxCheck(idx, i) and rowCheck(idx, i):
                sudoku[idx] = i
                backTracking(idx + 1, sudoku, zero - 1)
                sudoku[idx] = 0


backTracking(0, sudoku, zero)
