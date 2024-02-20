mod = 1000000009
t = int(input())

ans = [0 for _ in range(1000001)]

ans[1] = 1
ans[2] = 2
ans[3] = 4

for i in range(4, 1000001):
    ans[i] = (ans[i - 3]) % mod + (ans[i - 2]) % mod + ans[i - 1] % mod

for _ in range(t):
    print(ans[int(input())] % mod)
