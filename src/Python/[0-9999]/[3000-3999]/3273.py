from itertools import combinations

n = int(input())
arr = list(map(int, input().split()))
numbers = [False for _ in range(1000001)]
x = int(input())
ans = 0

for i in arr:
    numbers[i] = True

for a in range(1000001):
    if numbers[a]:
        if x - a < 0 or x - a > 1000000:
            continue
        if numbers[x - a] == True:
            ans += 1

print(int(ans / 2))
