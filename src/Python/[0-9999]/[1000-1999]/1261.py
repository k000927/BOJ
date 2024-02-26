from collections import deque

n, m = map(int, input().split())
miro = [list(map(int, list(input()))) for _ in range(m)]
wall = [[1000 for _ in range(n)] for _ in range(m)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
ans = float("inf")
queue = deque()
queue.append([0, 0, 0])
wall[0][0] = 0
while queue:
    x, y, w = queue.popleft()
    if x == m - 1 and y == n - 1:
        ans = min(ans, w)
    else:
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if (
                next_x < 0
                or next_x >= m
                or next_y < 0
                or next_y >= n
                or wall[next_x][next_y] <= w
            ):
                continue
            if miro[next_x][next_y] == 1:
                wall[next_x][next_y] = w + 1
                queue.append([next_x, next_y, w + 1])
            else:
                wall[next_x][next_y] = w
                queue.append([next_x, next_y, w])

print(ans)
