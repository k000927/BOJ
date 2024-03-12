import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())

arr = [0] + list(input().split(" "))

dp = [[False for _ in range(n + 1)] for _ in range(n + 1)]

for i in range(1, n + 1):
    dp[i][i] = True

for i in range(1, n):
    if arr[i] == arr[i + 1]:
        dp[i][i + 1] = True

for leng in range(3, n + 1):
    for i in range(1, n + 1):
        if i + leng - 1 >= n + 1:
            break
        if arr[i] != arr[i + leng - 1]:
            continue
        if dp[i + 1][i + leng - 2]:
            dp[i][i + leng - 1] = True

m = int(input())
for _ in range(m):
    s, e = map(int, input().split())
    if dp[s][e]:
        print(1)
    else:
        print(0)
