import sys

input = sys.stdin.readline

arr = [0 for _ in range(1000001)]
ans = [0 for _ in range(1000001)]
ans[1] = 1
for n in range(1, 1000001):
    for m in range(1, 1000001):
        if n * m > 1000000:
            break
        arr[n * m] += n
    ans[n] = ans[n - 1] + arr[n]

t = int(input())
for _ in range(t):
    print(ans[int(input())])
