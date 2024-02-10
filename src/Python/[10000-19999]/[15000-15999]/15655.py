from itertools import combinations

n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()

arr = list(combinations(num, m))

for a in arr:
    for n in a:
        print(n, end=" ")
    print()
