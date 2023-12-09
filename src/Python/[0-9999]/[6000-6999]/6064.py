import sys

t = int(sys.stdin.readline().strip())


def GCD(x, y):
    while y:
        x, y = y, x % y
    return x


def LCM(x, y):
    result = (x * y) // GCD(x, y)
    return result


for _ in range(t):
    is_minusone = True
    m, n, x, y = map(int, sys.stdin.readline().strip().split())
    k = x
    while k <= m * n:
        if (k - x) % m == 0 and (k - y) % n == 0:
            print(k)
            is_minusone = False
            break
        k += m
    if is_minusone:
        print(-1)
