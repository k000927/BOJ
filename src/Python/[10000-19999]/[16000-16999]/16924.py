n, m = map(int, input().split())

crossBoard = [list(input()) for _ in range(n)]
emptyBoard = [["." for _ in range(m)] for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

ans = []


def putCross(x, y, size):
    for i in range(4):
        nx = x + dx[i] * size
        ny = y + dy[i] * size
        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            return False
        if crossBoard[nx][ny] == ".":
            return False
    emptyBoard[x][y] = "*"
    for i in range(4):
        nx = x + dx[i] * size
        ny = y + dy[i] * size
        emptyBoard[nx][ny] = "*"
    return True


for i in range(n):
    for j in range(m):
        if crossBoard[i][j] == ".":
            continue
        size = 1
        while True:
            if putCross(i, j, size):
                ans.append([i + 1, j + 1, size])
                size += 1
            else:
                break

for i in range(n):
    for j in range(m):
        if emptyBoard[i][j] != crossBoard[i][j]:
            print(-1)
            exit()

print(len(ans))
for a in ans:
    print(" ".join(map(str, a)))
