n = int(input())

house = [list(map(int, input().split())) for _ in range(n)]

dp = [[[0, 0, 0] for _ in range(n)] for _ in range(n)]  # ㅡ, \, |

dp[0][1][0] = 1

for i in range(n):
    for j in range(n):
        if house[i][j] == 1:
            continue
        if j - 1 >= 0:
            dp[i][j][0] += dp[i][j - 1][0]
            dp[i][j][0] += dp[i][j - 1][1]
        if i - 1 >= 0 and j - 1 >= 0 and house[i - 1][j] == 0 and house[i][j - 1] == 0:
            dp[i][j][1] += dp[i - 1][j - 1][0]
            dp[i][j][1] += dp[i - 1][j - 1][2]
            dp[i][j][1] += dp[i - 1][j - 1][1]
        if j - 1 >= 0:
            dp[i][j][2] += dp[i - 1][j][2]
            dp[i][j][2] += dp[i - 1][j][1]

print(sum(dp[-1][-1]))
