from copy import deepcopy

n, m, r = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]


def op1():
    global arr
    tempArr = []
    for i in range(n - 1, -1, -1):
        tempArr.append(arr[i])
    arr = deepcopy(tempArr)


def op2():
    global arr
    tempArr = []
    for i in range(n):
        tempArr.append(arr[i][::-1])
    arr = deepcopy(tempArr)


def op3():
    global arr
    tempArr = []
    for j in range(m):
        tempLine = []
        for i in range(n):
            tempLine.append(arr[i][j])
        tempArr.append(tempLine[::-1])
    arr = deepcopy(tempArr)


def op4():
    global arr
    tempArr = []
    for j in range(m - 1, -1, -1):
        tempLine = []
        for i in range(n):
            tempLine.append(arr[i][j])
        tempArr.append(tempLine)
    arr = deepcopy(tempArr)


def op5():
    global arr
    tempArr = [[0 for _ in range(m)] for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if 0 <= i < n // 2:
                if 0 <= j < m // 2:
                    tempArr[i][j + m // 2] = arr[i][j]
                else:
                    tempArr[i + n // 2][j] = arr[i][j]
            else:
                if 0 <= j < m / 2:
                    tempArr[i - n // 2][j] = arr[i][j]
                else:
                    tempArr[i][j - m // 2] = arr[i][j]
    arr = deepcopy(tempArr)


def op6():
    global arr
    tempArr = [[0 for _ in range(m)] for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if 0 <= i < n // 2:
                if 0 <= j < m // 2:
                    tempArr[i + n // 2][j] = arr[i][j]
                else:
                    tempArr[i][j - m // 2] = arr[i][j]
            else:
                if 0 <= j < m / 2:
                    tempArr[i][j + m // 2] = arr[i][j]
                else:
                    tempArr[i - n // 2][j] = arr[i][j]
    arr = deepcopy(tempArr)


ops = list(map(int, input().split()))

for op in ops:
    if op == 1:
        op1()
    elif op == 2:
        op2()
    elif op == 3:
        op3()
        n, m = m, n
    elif op == 4:
        op4()
        n, m = m, n
    elif op == 5:
        op5()
    else:
        op6()

for line in arr:
    print(" ".join(map(str, line)))
