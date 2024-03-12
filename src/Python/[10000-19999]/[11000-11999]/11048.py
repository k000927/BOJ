n, m = map(int, input().split())
maze = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(m)] for _ in range(n)]

for i in range(n):
    for j in range(m):
        if i > 0:
            if j > 0:
                dp[i][j] = maze[i][j] + max(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1])
            else:
                dp[i][j] = maze[i][j] + dp[i - 1][j]
        else:
            if j > 0:
                dp[i][j] = maze[i][j] + dp[i][j - 1]
            else:
                dp[i][j] = maze[i][j]

print(dp[n - 1][m - 1])
