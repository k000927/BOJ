import sys

n, k = map(int, input().split())
coins = set()
for _ in range(n):
    coins.add(int(input()))

dp = [0 for _ in range(k + 1)]

for i in range(1, k + 1):
    temp = sys.maxsize
    for coin in coins:
        if i - coin < 0:
            continue
        temp = min(dp[i - coin] + 1, temp)
    dp[i] = temp

print(dp[k] if dp[k] != sys.maxsize else -1)
