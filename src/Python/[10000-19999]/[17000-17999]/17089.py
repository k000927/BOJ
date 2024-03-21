from itertools import combinations

n, m = map(int, input().split())
friend = [set() for _ in range(n + 1)]
ans = 4001

for _ in range(m):
    x, y = map(int, input().split())
    friend[x].add(y)
    friend[y].add(x)


def getAns(a):
    global ans
    friends = list(combinations(friend[a], 2))
    for f in friends:
        if f[1] not in friend[f[0]]:
            continue
        ans = min(ans, len(friend[a]) + len(friend[f[0]]) + len(friend[f[1]]) - 6)


for i in range(1, n + 1):
    getAns(i)

print(ans if ans != 4001 else -1)
