import sys

input = sys.stdin.readline

m = int(input())

MODNUM = 1000000007

ans = 0


def fpow(C, n):
    if n == 1:
        return C % MODNUM
    else:
        x = fpow(C, n // 2)
        if n % 2 == 0:
            return (x % MODNUM * x % MODNUM) % MODNUM
        else:
            return ((x % MODNUM * x % MODNUM) % MODNUM * C % MODNUM) % MODNUM


ans = 0

for _ in range(m):
    b, a = map(int, input().split())
    ans = (ans % MODNUM + a % MODNUM * fpow(b, MODNUM - 2) % MODNUM) % MODNUM

print(ans)
