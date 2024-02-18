n = int(input())
p = [0] + list(map(int, input().split()))
dp = [10**9 for _ in range(n + 1)]
dp[0] = p[0]
for i in range(1, n + 1):
    for j in range(n):
        dp[i] = min(dp[j] + p[i - j], dp[i])
print(dp[n])
