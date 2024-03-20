import sys

input = sys.stdin.readline

n = int(input())
B = list(map(int, input().split()))

if n == 1:
    print(0)
    exit()


def check(first, second, b):
    diff = second - first
    new = [first + diff * i for i in range(len(b))]
    flag = True
    change = 0
    for i in range(2, len(b)):
        if abs(new[i] - b[i]) > 1:
            return [False, change]
        if new[i] == b[i]:
            pass
        else:
            change += 1
    return [True, change]


ans = 999999999
for k in [-1, 0, 1]:
    for u in [-1, 0, 1]:
        flag, change = check(B[0] + k, B[1] + u, B)
        if flag:
            if k != 0:
                change += 1
            if u != 0:
                change += 1
            ans = min(ans, change)

print(ans if ans != 999999999 else -1)
