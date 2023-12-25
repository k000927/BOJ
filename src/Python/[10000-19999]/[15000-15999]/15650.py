from itertools import combinations

n, m = map(int, input().split())

arr = list(map(lambda i: i + 1, range(n)))

for i in combinations(arr, m):
    i = list(map(str, i))
    print(" ".join(i))
