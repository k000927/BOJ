aLen = int(input())
a = list(map(int, input().split()))
dp = [1] * aLen

for i in range(aLen):
    for j in range(i):
        if a[i] > a[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))

sub = []
order = max(dp)

for i in range(aLen - 1, -1, -1):
    if dp[i] == order:
        sub.append(a[i])
        order -= 1

sub.reverse()
print(*sub)
