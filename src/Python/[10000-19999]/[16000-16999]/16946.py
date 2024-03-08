from collections import deque

n, m = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list(map(int, list(input()))))
visited = [[False for _ in range(m)] for _ in range(n)]
maps = [[0 for _ in range(m)] for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
idx = 0


def bfs(i, j):
    global idx
    localArr = []
    cnt = 1
    queue = deque()
    queue.append((i, j))
    visited[i][j] = True
    while queue:
        a, b = queue.popleft()
        localArr.append((a, b))
        for k in range(4):
            x = a + dx[k]
            y = b + dy[k]
            if 0 <= x < n and 0 <= y < m and not visited[x][y] and graph[x][y] == 0:
                cnt += 1
                visited[x][y] = True
                queue.append((x, y))
    for node in localArr:
        x, y = node
        maps[x][y] = (cnt, idx)
    idx += 1


for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            continue
        elif not visited[i][j]:
            bfs(i, j)

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            continue
        arr = []
        for k in range(4):
            x = i + dx[k]
            y = j + dy[k]
            if 0 <= x < n and 0 <= y < m:
                var = maps[x][y]
                if var == 0:
                    continue
                cnt, idx = var
                if idx in arr:
                    continue
                arr.append(idx)
                graph[i][j] += cnt

for i in range(n):
    for j in range(m):
        print(graph[i][j] % 10, end="")
    print()
