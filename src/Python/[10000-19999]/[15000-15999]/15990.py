t = int(input())

mod = 1000000009
ans = [[] for _ in range(100001)]
ans[1] = [1, 0, 0]
ans[2] = [0, 1, 0]
ans[3] = [1, 1, 1]

for i in range(4, 100001):
    ans[i].append((ans[i - 1][1] + ans[i - 1][2]) % mod)
    ans[i].append((ans[i - 2][0] + ans[i - 2][2]) % mod)
    ans[i].append((ans[i - 3][0] + ans[i - 3][1]) % mod)

for _ in range(t):
    n = int(input())
    print((sum(ans[n])) % mod)
