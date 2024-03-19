n, k = map(int, input().split())
s = list(map(int, input().split()))
h = list(map(int, input().split()))
dp = [[0 for _ in range(101)] for _ in range(n)]

dp[0][100 - h[0]] = s[0]
ans = 0

for i in range(n - 1):
    for j in range(101):
        nextH_notPlay = min(100, j + k)
        dp[i + 1][nextH_notPlay] = max(dp[i + 1][nextH_notPlay], dp[i][j])
        nextH_Play = min(100, j + k) - h[i + 1]
        if nextH_Play < 0:
            continue
        dp[i + 1][nextH_Play] = max(dp[i + 1][nextH_Play], dp[i][j] + s[i + 1])

for i in range(n):
    for j in range(101):
        ans = max(ans, dp[i][j])

print(ans)
