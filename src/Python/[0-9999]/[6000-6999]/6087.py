from collections import deque
import sys

input = sys.stdin.readline
w, h = map(int, input().split())
graph = [list(input()) for _ in range(h)]
visited = [[10000 for _ in range(w)] for _ in range(h)]
dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]
razor = []
for i in range(h):
    for j in range(w):
        if graph[i][j] == "C":
            razor.append((i, j))

queue = deque()
queue.append((razor[0][0], razor[0][1], 0, -1))
visited[razor[0][0]][razor[0][1]] = 0
ans = 10000

while queue:
    i, j, mirror, preDir = queue.popleft()
    if i == razor[1][0] and j == razor[1][1]:
        ans = min(ans, mirror)
    else:
        for k in range(4):
            x = i + dx[k]
            y = j + dy[k]
            if x < 0 or x >= h or y < 0 or y >= w:
                continue
            if graph[x][y] == "*":
                continue
            if preDir == -1 or k == preDir:
                if visited[x][y] < mirror:
                    continue
                visited[x][y] = mirror
                queue.append((x, y, mirror, k))
            else:
                if visited[x][y] < mirror + 1:
                    continue
                visited[x][y] = mirror + 1
                queue.append((x, y, mirror + 1, k))

print(ans)
