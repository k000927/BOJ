n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def dfs(c, queue, visited):
    if len(queue) >= 4 and queue[0] == queue[-1]:
        print("Yes")
        exit()
    else:
        i, j = queue[-1]
        for k in range(4):
            x = i + dx[k]
            y = j + dy[k]
            if 0 <= x < n and 0 <= y < m and board[x][y] == c and not visited[x][y]:
                visited[x][y] = True
                dfs(c, queue + [(x, y)], visited)
                visited[x][y] = False


for i in range(n):
    for j in range(m):
        dfs(board[i][j], [(i, j)], visited)

print("No")
