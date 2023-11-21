N = int(input())
count = 0

chess = [0] * N


def is_promising(x):
    for i in range(x):
        if chess[x] == chess[i] or abs(chess[x] - chess[i]) == abs(x - i):
            return False
    return True


def getCase(x):
    global count
    if x == N:
        count += 1
    else:
        for i in range(N):
            chess[x] = i
            if is_promising(x):
                getCase(x + 1)


getCase(0)
print(count)
