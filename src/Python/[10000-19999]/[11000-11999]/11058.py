n = int(input())

dp = [0 for _ in range(101)]
dp[1] = 1
dp[2] = 2
dp[3] = 3

for i in range(4, 101):
    temp = dp[i - 1] + 1
    for j in range(i - 3, 0, -1):
        x = dp[j] * (i - j - 1)
        temp = max(temp, dp[j] * (i - j - 1))
    dp[i] = temp

print(dp[n])
