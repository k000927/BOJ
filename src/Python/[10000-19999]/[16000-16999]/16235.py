n, m, k = map(int, input().split())
nutrition = [[0] * (n + 1)] + [[0] + [5 for _ in range(n)] for _ in range(n)]
A = [[0] * (n + 1)] + [[0] + list(map(int, input().split())) for _ in range(n)]
Trees = [[[] for _ in range(n + 1)] for _ in range(n + 1)]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]
for _ in range(m):
    x, y, z = map(int, input().split())
    Trees[x][y].append(z)

for i in range(1, n + 1):
    for j in range(1, n + 1):
        Trees[i][j].sort()


def spring_summer():
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            Trees[i][j].sort()
            newTree = []
            newNutrition = 0
            for Tree in Trees[i][j]:
                if Tree <= nutrition[i][j]:
                    nutrition[i][j] -= Tree
                    newTree.append(Tree + 1)
                else:
                    newNutrition += Tree // 2
            Trees[i][j] = newTree
            nutrition[i][j] += newNutrition


def fall():
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            for Tree in Trees[i][j]:
                if Tree % 5 == 0:
                    for k in range(8):
                        x = i + dx[k]
                        y = j + dy[k]
                        if x < 1 or x > n or y < 1 or y > n:
                            continue
                        Trees[x][y].append(1)


def winter():
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            nutrition[i][j] += A[i][j]


for _ in range(k):
    spring_summer()
    fall()
    winter()

ans = 0

for i in range(n + 1):
    for j in range(n + 1):
        ans += len(Trees[i][j])

print(ans)
