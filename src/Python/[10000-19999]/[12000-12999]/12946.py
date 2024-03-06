import sys

sys.setrecursionlimit(10**8)
N = int(input())
room = [list(input()) for _ in range(N)]
visited = [[-1] * N for _ in range(N)]
answer = 0
dir = ((-1, 0), (-1, 1), (0, 1), (1, 0), (1, -1), (0, -1))


def dfs(x, y, c):
    global answer
    answer = max(1, answer)
    visited[x][y] = c
    for d in range(6):
        nx = x + dir[d][0]
        ny = y + dir[d][1]

        if nx < 0 or nx >= N or ny < 0 or ny >= N:
            continue
        if room[nx][ny] == "X":
            if visited[nx][ny] == -1:
                answer = max(2, answer)
                dfs(nx, ny, (c + 1) % 2)
            elif visited[nx][ny] == c:
                print(3)
                exit(0)


for x in range(N):
    for y in range(N):
        if room[x][y] == "X" and visited[x][y] == -1:
            dfs(x, y, 0)
print(answer)
