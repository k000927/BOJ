import sys
from collections import deque

input = sys.stdin.readline
n, l = map(int, input().split())
a = list(map(int, input().split()))

dq = deque()
for i in range(n):

    while dq and dq[-1][1] > a[i]:
        dq.pop()

    dq.append((i + 1, a[i]))

    if dq[-1][0] - dq[0][0] >= l:
        dq.popleft()

    print(dq[0][1], end=" ")
