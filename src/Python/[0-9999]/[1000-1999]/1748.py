n = int(input())
ans = 0
for i in range(1, 10):
    if n < 10**i:
        ans += i * (n - (10 ** (i - 1))) + 1
        break
    else:
        ans += i * (10**i - 10 ** (i - 1)) + 1
print(ans)
