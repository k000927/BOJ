from copy import deepcopy

r, c, k = map(int, input().split())
x, y = 3, 3
A = [list(map(int, input().split())) for _ in range(3)]


def funcR():
    global x, y
    newA = []
    maxLength = 0
    for i in range(x):
        A[i].sort()
        nArr = [set() for _ in range(101)]
        for num in A[i]:
            if num == 0:
                continue
            flag = False
            for j in range(1, 101):
                if num in nArr[j]:
                    nArr[j].remove(num)
                    nArr[j + 1].add(num)
                    flag = True
                    break
            if not flag:
                nArr[1].add(num)
        tempArr = []
        for j in range(1, 101):
            if not nArr[j]:
                continue
            nArr[j] = sorted(nArr[j])
            for num in nArr[j]:
                tempArr.append(num)
                tempArr.append(j)
        newA.append(tempArr)
        maxLength = max(maxLength, len(tempArr))
    maxLength = min(100, maxLength)
    for i in range(x):
        A[i] = newA[i] + [0] * (maxLength - len(newA[i]))
    y = maxLength


def funcC():
    global x, y, A
    newA = []
    maxLength = 0
    for i in range(y):
        preLine = []
        for j in range(x):
            preLine.append(A[j][i])
        preLine.sort()
        nArr = [set() for _ in range(101)]
        for num in preLine:
            if num == 0:
                continue
            flag = False
            for j in range(1, 101):
                if num in nArr[j]:
                    nArr[j].remove(num)
                    nArr[j + 1].add(num)
                    flag = True
                    break
            if not flag:
                nArr[1].add(num)
        tempArr = []
        for j in range(1, 101):
            if not nArr[j]:
                continue
            nArr[j] = sorted(nArr[j])
            for num in nArr[j]:
                tempArr.append(num)
                tempArr.append(j)
        newA.append(tempArr)
        maxLength = max(maxLength, len(tempArr))
    maxLength = min(100, maxLength)
    curA = [[] for _ in range(maxLength)]
    for i in range(y):
        for j in range(len(newA[i])):
            curA[j].append(newA[i][j])
        for k in range(j + 1, maxLength):
            curA[k].append(0)
    A = deepcopy(curA)
    x = maxLength


ans = 0
while True:
    B = deepcopy(A)
    if x > r - 1 and y > c - 1 and A[r - 1][c - 1] == k:
        print(ans)
        break
    if ans == 100:
        print(-1)
        break
    if x >= y:
        funcR()
    else:
        funcC()
    ans += 1
