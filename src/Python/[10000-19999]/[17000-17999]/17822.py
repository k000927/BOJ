n, m, t = map(int, input().split())
plates = [0] + [list(map(int, input().split())) for _ in range(n)]


def spinPlate(x, d, k):
    if d == 0:
        plates[x] = plates[x][-k:] + plates[x][:-k]
    else:
        plates[x] = plates[x][k:] + plates[x][:k]


def adjPlate(x):
    global flag, newPlates
    for idx in range(m):
        temp = plates[x][idx]
        if plates[x][idx] == 0:
            continue
        if x != n:
            if plates[x][idx] == plates[x + 1][idx]:
                newPlates[x][idx] = 0
                newPlates[x + 1][idx] = 0
                temp = 0
                flag = True
        if x != 1:
            if plates[x][idx] == plates[x - 1][idx]:
                newPlates[x][idx] = 0
                newPlates[x - 1][idx] = 0
                temp = 0
                flag = True
        l = idx - 1 if idx - 1 >= 0 else m - 1
        if plates[x][idx] == plates[x][l]:
            newPlates[x][idx] = 0
            newPlates[x][l] = 0
            temp = 0
            flag = True
        r = idx + 1 if idx + 1 < m else 0
        if plates[x][idx] == plates[x][r]:
            newPlates[x][idx] = 0
            newPlates[x][r] = 0
            temp = 0
            flag = True
        newPlates[x][idx] = temp


for _ in range(t):
    x, d, k = map(int, input().split())
    for i in range(x, n + 1, x):
        spinPlate(i, d, k)
    flag = False
    newPlates = [0] + [[0 for _ in range(m)] for _ in range(n)]
    for i in range(1, n + 1):
        adjPlate(i)
    plates = newPlates
    if not flag:
        suma = 0
        cnt = 0
        for i in range(1, n + 1):
            for j in range(m):
                if plates[i][j] == 0:
                    continue
                suma += plates[i][j]
                cnt += 1
        if cnt == 0:
            continue
        avg = suma / cnt
        for i in range(1, n + 1):
            for j in range(m):
                if plates[i][j] == 0:
                    continue
                if plates[i][j] > avg:
                    plates[i][j] -= 1
                elif plates[i][j] < avg:
                    plates[i][j] += 1

ans = 0
for line in plates[1:]:
    ans += sum(line)
print(ans)
