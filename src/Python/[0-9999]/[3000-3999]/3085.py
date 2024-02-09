import sys

input = sys.stdin.readline

n = int(input())
maxLine = 0
candy = [list(input().strip()) for _ in range(n)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def getMax(candy, startI, endI, startJ, endJ):
    global maxLine
    for i in [startI, endI]:
        curCol = "X"
        preCol = "X"
        localMax = 1
        for j in range(n):
            curCol = candy[i][j]
            if curCol == preCol:
                localMax += 1
                maxLine = max(maxLine, localMax)
            else:
                localMax = 1
                maxLine = max(maxLine, localMax)
            preCol = curCol
    for j in [startJ, endJ]:
        curCol = "X"
        preCol = "X"
        localMax = 1
        for i in range(n):
            curCol = candy[i][j]
            if curCol == preCol:
                localMax += 1
                maxLine = max(maxLine, localMax)
            else:
                localMax = 1
                maxLine = max(maxLine, localMax)
            preCol = curCol


for i in range(n):
    curCol = "X"
    preCol = "X"
    localMax = 1
    for j in range(n):
        curCol = candy[i][j]
        if curCol == preCol:
            localMax += 1
            maxLine = max(maxLine, localMax)
        else:
            localMax = 1
            maxLine = max(maxLine, localMax)
        preCol = curCol
for j in range(n):
    curCol = "X"
    preCol = "X"
    localMax = 1
    for i in range(n):
        curCol = candy[i][j]
        if curCol == preCol:
            localMax += 1
            maxLine = max(maxLine, localMax)
        else:
            localMax = 1
            maxLine = max(maxLine, localMax)
        preCol = curCol

for i in range(n):
    for j in range(n):
        for k in range(4):
            x = i + dx[k]
            y = j + dy[k]
            if 0 <= x < n and 0 <= y < n and candy[i][j] != candy[x][y]:
                candy[x][y], candy[i][j] = candy[i][j], candy[x][y]
                getMax(candy, i, x, j, y)
                candy[x][y], candy[i][j] = candy[i][j], candy[x][y]

print(maxLine)
