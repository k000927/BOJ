from itertools import combinations
from copy import deepcopy

n, m, h = map(int, input().split())

ladder = [[0] + [i for _ in range(h)] for i in range(n + 1)]

cand = []
for _ in range(m):
    a, b = map(int, input().split())
    ladder[b][a] = b + 1
    ladder[b + 1][a] = b

for i in range(1, n):
    for j in range(1, h + 1):
        if ladder[i][j] != i or ladder[i + 1][j] != i + 1:
            continue
        cand.append((i, j))

ans = 4


def game(ladder, listC):
    global ans
    for i in listC:
        ladder[cand[i][0]][cand[i][1]] = cand[i][0] + 1
        ladder[cand[i][0] + 1][cand[i][1]] = cand[i][0]
    for i in range(1, n + 1):
        curLine = i
        for j in range(1, h + 1):
            curLine = ladder[curLine][j]
        if curLine != i:
            for i in listC:
                ladder[cand[i][0]][cand[i][1]] = cand[i][0]
                ladder[cand[i][0] + 1][cand[i][1]] = cand[i][0] + 1
            return
    for i in listC:
        ladder[cand[i][0]][cand[i][1]] = cand[i][0]
        ladder[cand[i][0] + 1][cand[i][1]] = cand[i][0] + 1
    ans = min(ans, len(listC))


if game(ladder, []):
    print(0)
    exit()

for i in range(len(cand)):
    game(ladder, [i])
    for j in range(i + 1, len(cand)):
        game(ladder, [i, j])
        for k in range(j + 1, len(cand)):
            game(ladder, [i, j, k])

print(ans if ans != 4 else -1)
