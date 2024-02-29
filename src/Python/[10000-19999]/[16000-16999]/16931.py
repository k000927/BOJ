n, m = map(int, input().split())
cube = [list(map(int, input().split())) for _ in range(n)]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
ans = 0


def getSurf(i, j):
    surf = 1
    for k in range(4):
        x = i + dx[k]
        y = j + dy[k]
        if 0 <= x < n and 0 <= y < m:
            if cube[i][j] > cube[x][y]:
                surf += cube[i][j] - cube[x][y]
        else:
            surf += cube[i][j]
    return surf


for i in range(n):
    for j in range(m):
        ans += getSurf(i, j)

print(ans + n * m)
