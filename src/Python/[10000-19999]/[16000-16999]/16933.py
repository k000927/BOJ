from collections import deque
import sys

n, m, k = map(int, sys.stdin.readline().split())
graph = [list(sys.stdin.readline()) for _ in range(n)]
wallCnt = [[1000001 for _ in range(m)] for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

queue = deque()
queue.append((0, 0, 0, 1, True))

while queue:
    i, j, wall, cnt, day = queue.popleft()
    if i == n - 1 and j == m - 1:
        print(cnt)
        exit()
    for a in range(4):
        x = i + dx[a]
        y = j + dy[a]
        if 0 <= x < n and 0 <= y < m:
            if graph[x][y] == "1" and wall < k and wallCnt[x][y] > wall + 1:
                if day:
                    wallCnt[x][y] = wall + 1
                    queue.append((x, y, wall + 1, cnt + 1, False))
                if not day:
                    queue.append((i, j, wall, cnt + 1, True))
            elif graph[x][y] == "0" and wallCnt[x][y] > wall:
                wallCnt[x][y] = wall
                queue.append((x, y, wall, cnt + 1, not day))

print(-1)
