from copy import deepcopy

n = list(map(int, input().split()))
cube = []
for i in range(0, 24, 4):
    cube.append([n[i], n[i + 1], n[i + 2], n[i + 3]])


def isSolved(cube):
    for i in range(6):
        for n in cube[i]:
            if n != cube[i][0]:
                return
    print(1)
    exit()


def spin1():
    c = deepcopy(cube)
    c[3][0], c[3][1], c[1][0], c[1][1], c[4][0], c[4][1], c[5][0], c[5][1] = (
        c[1][0], c[1][1], c[4][0], c[4][1], c[5][0], c[5][1], c[3][0], c[3][1])
    isSolved(c)


def spin2():
    c = deepcopy(cube)
    c[3][0], c[3][1], c[1][0], c[1][1], c[4][0], c[4][1], c[5][0], c[5][1] = (
        c[5][0], c[5][1], c[3][0], c[3][1], c[1][0], c[1][1], c[4][0], c[4][1])
    isSolved(c)


def spin3():
    c = deepcopy(cube)
    c[3][2], c[3][3], c[1][2], c[1][3], c[4][2], c[4][3], c[5][2], c[5][3] = (
        c[1][2], c[1][3], c[4][2], c[4][3], c[5][2], c[5][3], c[3][2], c[3][3])
    isSolved(c)


def spin4():
    c = deepcopy(cube)
    c[3][2], c[3][3], c[1][2], c[1][3], c[4][2], c[4][3], c[5][2], c[5][3] = (
        c[5][2], c[5][3], c[3][2], c[3][3], c[1][2], c[1][3], c[4][2], c[4][3])
    isSolved(c)


def spin5():
    c = deepcopy(cube)
    c[5][3], c[5][1], c[0][0], c[0][2], c[1][0], c[1][2], c[2][0], c[2][2] = (
        c[0][0], c[0][2], c[1][0], c[1][2], c[2][0], c[2][2], c[5][3], c[5][1])
    isSolved(c)


def spin6():
    c = deepcopy(cube)
    c[5][3], c[5][1], c[0][0], c[0][2], c[1][0], c[1][2], c[2][0], c[2][2] = (
        c[2][0], c[2][2], c[5][3], c[5][1], c[0][0], c[0][2], c[1][0], c[1][2])
    isSolved(c)


def spin7():
    c = deepcopy(cube)
    c[5][2], c[5][0], c[0][1], c[0][3], c[1][1], c[1][3], c[2][1], c[2][3] = (
        c[0][1], c[0][3], c[1][1], c[1][3], c[2][1], c[2][3], c[5][2], c[5][0])
    isSolved(c)


def spin8():
    c = deepcopy(cube)
    c[5][2], c[5][0], c[0][1], c[0][3], c[1][1], c[1][3], c[2][1], c[2][3] = (
        c[2][1], c[2][3], c[5][2], c[5][0], c[0][1], c[0][3], c[1][1], c[1][3])
    isSolved(c)


def spin9():
    c = deepcopy(cube)
    c[3][3], c[3][1], c[0][2], c[0][3], c[4][0], c[4][2], c[2][1], c[2][0] = (
        c[2][1], c[2][0], c[3][3], c[3][1], c[0][2], c[0][3], c[4][0], c[4][2])
    isSolved(c)


def spin10():
    c = deepcopy(cube)
    c[3][3], c[3][1], c[0][2], c[0][3], c[4][0], c[4][2], c[2][1], c[2][0] = (
        c[0][2], c[0][3], c[4][0], c[4][2], c[2][1], c[2][0], c[3][3], c[3][1])
    isSolved(c)


def spin11():
    c = deepcopy(cube)
    c[3][2], c[3][0], c[0][0], c[0][1], c[4][1], c[4][3], c[2][3], c[2][2] = (
        c[0][0], c[0][1], c[4][1], c[4][3], c[2][3], c[2][2], c[3][2], c[3][0])
    isSolved(c)


def spin12():
    c = deepcopy(cube)
    c[3][2], c[3][0], c[0][0], c[0][1], c[4][1], c[4][3], c[2][3], c[2][2] = (
        c[2][3], c[2][2], c[3][2], c[3][0], c[0][0], c[0][1], c[4][1], c[4][3])
    isSolved(c)


spin1()
spin2()
spin3()
spin4()
spin5()
spin6()
spin7()
spin8()
spin9()
spin10()
spin11()
spin12()

print(0)
