from itertools import permutations

ans_list = []

for a in list(permutations(range(1, 10), 9)):
    if a[0] + a[1] + a[2] != 15:
        continue
    if a[3] + a[4] + a[5] != 15:
        continue
    if a[6] + a[7] + a[8] != 15:
        continue
    if a[0] + a[3] + a[6] != 15:
        continue
    if a[1] + a[4] + a[7] != 15:
        continue
    if a[2] + a[5] + a[8] != 15:
        continue
    if a[0] + a[4] + a[8] != 15:
        continue
    if a[2] + a[4] + a[6] != 15:
        continue
    ans_list.append(a)

A = []
for _ in range(3):
    A += list(map(int, input().split()))

ans = 10 ** 9

for l in ans_list:
    localAns = 0
    for i in range(9):
        localAns += abs(l[i] - A[i])
    ans = min(localAns, ans)

print(ans)
