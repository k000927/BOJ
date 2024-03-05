from collections import deque
from copy import deepcopy

n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]
for i in range(n):
    for j in range(m):
        if board[i][j] == "B":
            blue = (i, j)
        if board[i][j] == "R":
            red = (i, j)

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

visited = [
    [[[False for _ in range(m)] for _ in range(n)] for _ in range(m)] for _ in range(n)
]

queue = deque()
queue.append((red, blue, 0, board))

rtX, rtY, btX, btY = 0, 0, 0, 0


def moveBid(red_x, red_y, blue_x, blue_y, i, board):
    global rtX, rtY, btX, btY
    redFlag = False
    blueFlag = False
    goal = False
    while True:
        if not blueFlag:
            blue_x += dx[i]
            blue_y += dy[i]
            if board[blue_x][blue_y] == "O":
                return 0
            if board[blue_x][blue_y] == "#":
                blue_x -= dx[i]
                blue_y -= dy[i]
                blueFlag = True
            if redFlag and blue_x == red_x and blue_y == red_y:
                blue_x -= dx[i]
                blue_y -= dy[i]
                blueFlag = True

        if not redFlag:
            red_x += dx[i]
            red_y += dy[i]
            if board[red_x][red_y] == "#":
                red_x -= dx[i]
                red_y -= dy[i]
                redFlag = True
                if red_x == blue_x and red_y == blue_y:
                    blue_x -= dx[i]
                    blue_y -= dy[i]
                    blueFlag = True
            elif board[red_x][red_y] == "O":
                redFlag = True
                goal = True
            elif blueFlag and red_x == blue_x and red_y == blue_y:
                red_x -= dx[i]
                red_y -= dy[i]
                redFlag = True

        if redFlag and blueFlag:
            if goal:
                return 1
            if visited[red_x][red_y][blue_x][blue_y]:
                return 0
            rtX, rtY, btX, btY = red_x, red_y, blue_x, blue_y
            visited[red_x][red_y][blue_x][blue_y] = True
            return 2


while queue:
    ((red_x, red_y), (blue_x, blue_y), cnt, localBoard) = queue.popleft()
    if cnt > 10:
        print(-1)
        exit()
    for i in range(4):
        j = moveBid(red_x, red_y, blue_x, blue_y, i, localBoard)
        if j == 0:
            continue
        elif j == 1:
            if cnt + 1 > 10:
                print(-1)
            else:
                print(cnt + 1)
            exit()
        else:
            localBoard[red_x][red_y] = "."
            localBoard[blue_x][blue_y] = "."
            localBoard[rtX][rtY] = "R"
            localBoard[btX][btY] = "B"
            queue.append(((rtX, rtY), (btX, btY), cnt + 1, deepcopy(localBoard)))
            localBoard[rtX][rtY] = "."
            localBoard[btX][btY] = "."
            localBoard[red_x][red_y] = "R"
            localBoard[blue_x][blue_y] = "B"

print(-1)
