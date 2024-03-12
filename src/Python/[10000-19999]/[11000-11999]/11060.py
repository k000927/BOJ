n = int(input())
maze = list(map(int, input().split()))
dp = [n + 1 for _ in range(n)]

dp[0] = 0

for i in range(n):
    for j in range(1, maze[i] + 1):
        if i + j < n:
            dp[i + j] = min(dp[i] + 1, dp[i + j])

print(dp[-1] if dp[-1] != n + 1 else -1)
