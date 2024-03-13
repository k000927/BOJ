from collections import deque
from copy import deepcopy
import math

n, l, r = map(int, input().split())
nations = [list(map(int, input().split())) for _ in range(n)]
borderLine = [[[False, False, False, False] for _ in range(n)] for _ in range(n)]
ans = 0
dx = [0, 1, 0, -1]  # 오른쪽, 아래, 왼쪽, 위
dy = [1, 0, -1, 0]
queue = deque()

while True:
    tempBorderLine = [[[False, False, False, False] for _ in range(n)] for _ in range(n)]
    flag = False
    for i in range(n):
        for j in range(n):
            for k in range(4):
                x = i + dx[k]
                y = j + dy[k]
                if x < 0 or x >= n or y < 0 or y >= n:
                    continue
                if l <= abs(nations[i][j] - nations[x][y]) <= r:
                    flag = True
                    tempBorderLine[i][j][k] = True
    if not flag:
        break
    visited = [[False for _ in range(n)] for _ in range(n)]
    queue = deque()
    for i in range(n):
        for j in range(n):
            if visited[i][j]:
                continue

            queue.append((i, j))
            visited[i][j] = True

            arr = []
            nation = 1
            po = nations[i][j]
            while queue:
                a, b = queue.popleft()
                arr.append((a, b))
                for k in range(4):
                    e = tempBorderLine[a][b][k]
                    if not tempBorderLine[a][b][k]:
                        continue
                    x = a + dx[k]
                    y = b + dy[k]
                    if x < 0 or x >= n or y < 0 or y >= n:
                        continue
                    if visited[x][y]:
                        continue
                    nation += 1
                    po += nations[x][y]
                    visited[x][y] = True
                    queue.append((x, y))

            for z in arr:
                q, w = z
                nations[q][w] = po // nation

    ans += 1

print(ans)
