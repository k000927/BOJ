from collections import deque

n, m = map(int, input().split())
sea = [list(map(int, input().split())) for _ in range(n)]

ans = -1

dx = [0, 0, -1, 1, 1, 1, -1, -1]
dy = [-1, 1, 0, 0, 1, -1, 1, -1]
safe = [[3000 for _ in range(m)] for _ in range(n)]


def bfs(i, j):
    global safe
    queue = deque()
    queue.append((i, j, 0))
    visited = [[False for _ in range(m)] for _ in range(n)]
    safe[i][j] = 0
    while queue:
        x, y, cnt = queue.popleft()
        for k in range(8):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 > nx or n <= nx or ny < 0 or ny >= m:
                continue
            if visited[nx][ny]:
                continue
            if sea[nx][ny] == 1:
                continue
            if safe[nx][ny] <= cnt:
                continue
            safe[nx][ny] = cnt + 1
            visited[nx][ny] = True
            queue.append((nx, ny, cnt + 1))


for i in range(n):
    for j in range(m):
        if sea[i][j] == 1:
            bfs(i, j)

ans = -1

for line in safe:
    ans = max(ans, max(line))

print(ans)
