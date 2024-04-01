import sys

sys.setrecursionlimit(10 ** 9)

paper = []
for _ in range(10):
    paper += list(map(int, input().split()))

ans = 100


def attechable(paper, i):
    p_list = [False, True, False, False, False, False]
    for size in range(2, 6):
        for k in range(size):
            if i // 10 != (i + (size - 1)) // 10:
                return p_list
            if i + (size - 1) + 10 * k >= 100 or paper[i + (size - 1) + 10 * k] == 0:
                return p_list
            if i + (size - 1) * 10 + k >= 100 or paper[i + (size - 1) * 10 + k] == 0:
                return p_list
        p_list[size] = True
    return p_list


def back_tracking(paper, cnt, i, c):
    global ans
    if cnt >= ans:
        return
    if i == 100:
        ans = min(ans, cnt)
        return
    if paper[i] == 0:
        back_tracking(paper, cnt, i + 1, c)
        return
    p_list = attechable(paper, i)
    tempPaper = paper[:]
    for x in range(1, 6):
        if not p_list[x]:
            continue
        if c[x] == 0:
            continue
        for a in range(x):
            for b in range(x):
                tempPaper[i + 10 * a + b] = 0
        tempC = c[:]
        tempC[x] -= 1
        back_tracking(tempPaper, cnt + 1, i + 1, tempC)


back_tracking(paper, 0, 0, [0, 5, 5, 5, 5, 5])

print(ans if ans != 100 else -1)
