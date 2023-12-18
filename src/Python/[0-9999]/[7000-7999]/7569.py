from collections import deque
import sys


dx = [-1, 0, 1, 0, 0, 0]
dy = [0, 1, 0, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]
m, n, h = map(int, sys.stdin.readline().split())
board = [
    [list(map(int, sys.stdin.readline().split())) for _ in range(n)] for _ in range(h)
]
check = [[[0] * m for _ in range(n)] for _ in range(h)]
queue = deque()

for z in range(h):
    for x in range(n):
        for y in range(m):
            if board[z][x][y] == 1:
                queue.append((z, x, y))


def bfs():
    while queue:
        tmp = queue.popleft()

        for i in range(6):
            z = tmp[0] + dz[i]
            x = tmp[1] + dx[i]
            y = tmp[2] + dy[i]

            if (
                (0 <= x < n)
                and (0 <= y < m)
                and (0 <= z < h)
                and (board[z][x][y] == 0)
                and (check[z][x][y] == 0)
            ):
                board[z][x][y] = 1
                check[z][x][y] = check[tmp[0]][tmp[1]][tmp[2]] + 1
                queue.append((z, x, y))


bfs()
flag = True
result = -2147000000

for z in range(h):
    for x in range(n):
        for y in range(m):
            if board[z][x][y] == 0:
                flag = False
            result = max(result, check[z][x][y])

if flag:
    print(result)
else:
    print(-1)
