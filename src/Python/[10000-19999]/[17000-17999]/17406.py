import sys
from itertools import permutations

input = sys.stdin.readline

from copy import deepcopy

n, m, k = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(n)]
K = [list(map(int, input().split())) for _ in range(k)]


def spin(A, r, c, s):
    tempA = deepcopy(A)
    for x in range(1, s + 1):
        for i in range(-x + 1, x + 1):
            A[r - x][c + i] = tempA[r - x][c + i - 1]
        for i in range(-x + 1, x + 1):
            A[r + i][c + x] = tempA[r + i - 1][c + x]
        for i in range(-x, x):
            A[r + x][c + i] = tempA[r + x][c + i + 1]
        for i in range(-x, x):
            A[r + i][c - x] = tempA[r + i + 1][c - x]


def getAns(A):
    ans = sys.maxsize
    for line in A:
        ans = min(ans, sum(line))
    return ans


ops = list(permutations(K, k))

ans = sys.maxsize
for op in ops:
    tempA = deepcopy(A)
    for o in op:
        spin(tempA, o[0] - 1, o[1] - 1, o[2])
    ans = min(getAns(tempA), ans)

print(ans)
