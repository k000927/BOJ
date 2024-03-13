dp = [0 for _ in range(5001)]
dp[0] = 1

for n in range(2, 5001, 2):
    for i in range(2, n + 1, 2):
        dp[n] += dp[i - 2] * dp[n - i]
    dp[n] %= 1000000007
    
T = int(input())
for _ in range(T):
    print(dp[int(input())])
