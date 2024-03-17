from collections import deque
import sys

input = sys.stdin.readline

n = int(input())
B = list(map(int, input().split()))

ans = deque()
ans.append(B[0])
B = set(B)

stopAppendLeft = False
stopAppend = False

while len(ans) < n:
    if not stopAppendLeft:
        flag = True
        if ans[0] * 3 in B:
            ans.appendleft(ans[0] * 3)
            flag = False
        elif ans[0] % 2 == 0 and ans[0] // 2 in B:
            ans.appendleft(ans[0] // 2)
            flag = False
        stopAppendLeft = flag
    if not stopAppend:
        flag = True
        if ans[-1] % 3 == 0 and ans[-1] // 3 in B:
            ans.append(ans[-1] // 3)
            flag = False
        elif ans[-1] * 2 in B:
            ans.append(ans[-1] * 2)
            flag = False
        stopAppend = flag

print(" ".join(map(str, ans)))
