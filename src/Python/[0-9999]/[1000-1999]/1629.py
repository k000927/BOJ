a, b, c = map(int, input().split())


def fpow(C, n):
    global c
    if n == 1:
        return C % c
    else:
        x = fpow(C, n // 2)
        if n % 2 == 0:
            return ((x % c) * (x % c)) % c
        else:
            return ((x % c) * (x % c) * (C % c)) % c


print(fpow(a, b))
