from itertools import combinations

n = int(input())
s = list(map(int, input().split()))

num = [False for _ in range(2000001)]

for i in range(1, n + 1):
    l = combinations(s, i)
    for summ in l:
        num[sum(list(summ))] = True

for i in range(1, 2000001):
    if not num[i]:
        print(i)
        break
