import sys
from collections import deque
from copy import deepcopy

input = sys.stdin.readline

h, w = map(int, input().split())

cheese = []
for _ in range(h):
    cheese.append(list(map(int, input().split())))

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
cheeseNum = 0
days = 0


def getAir(startX, startY, cheese):
    queue = deque()
    visited = [[False for _ in range(w)] for _ in range(h)]
    visited[startX][startY] = True
    cheese[startX][startY] = 2
    queue.append((startX, startY))
    while queue:
        a, b = queue.popleft()
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]
            if 0 <= x < h and 0 <= y < w and cheese[x][y] != 1 and not visited[x][y]:
                queue.append((x, y))
                visited[x][y] = True
                cheese[x][y] = 2


def removeCheese():
    global cheese
    tempCheese = deepcopy(cheese)
    for i in range(h):
        for j in range(w):
            if cheese[i][j] == 2 or cheese[i][j] == 0:
                tempCheese[i][j] = 0
            else:
                for k in range(4):
                    x = i + dx[k]
                    y = j + dy[k]
                    if 0 <= x < h and 0 <= y < w:
                        if cheese[x][y] == 2:
                            tempCheese[i][j] = 0
                            break
    cheese = tempCheese


def isEmpty(cheese):
    cheeseNum = 0
    for i in range(h):
        for j in range(w):
            if cheese[i][j] == 1:
                cheeseNum += 1
    return cheeseNum


while True:
    tempNum = isEmpty(cheese)
    if tempNum == 0:
        print(days)
        print(cheeseNum)
        break
    cheeseNum = tempNum
    getAir(0, 0, cheese)
    removeCheese()
    days += 1
