from collections import deque

n = int(input())
r1, c1, r2, c2 = map(int, input().split())

visited = [[False for _ in range(n)] for _ in range(n)]
dx = [-2, -2, 0, 0, 2, 2]
dy = [-1, 1, -2, 2, -1, 1]

queue = deque()
visited[r1][c1] = True
queue.append((r1, c1, 0))

while queue:
    r, c, cnt = queue.popleft()
    if r == r2 and c == c2:
        print(cnt)
        exit()
    else:
        for i in range(6):
            x = r + dx[i]
            y = c + dy[i]
            if 0 <= x < n and 0 <= y < n and not visited[x][y]:
                visited[x][y] = True
                queue.append((x, y, cnt + 1))

print(-1)
