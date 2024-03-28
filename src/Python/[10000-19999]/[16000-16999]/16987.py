n = int(input())
s = []  # 내구도
w = []  # 무게
for _ in range(n):
    a, b = map(int, input().split())
    s.append(a)
    w.append(b)

ans = 0


def bf(egg, s):
    global ans, w
    if egg == n:
        localAns = 0
        for a in s:
            if a <= 0:
                localAns += 1
        ans = max(localAns, ans)
        return
    if s[egg] <= 0:
        bf(egg + 1, s)
        return
    flag = False
    for i in range(n):
        if i == egg or s[i] <= 0:
            continue
        tempS = s[:]
        tempS[egg] -= w[i]
        tempS[i] -= w[egg]
        bf(egg + 1, tempS)
        flag = True
    if not flag:
        bf(egg + 1, s)


bf(0, s)
print(ans)
