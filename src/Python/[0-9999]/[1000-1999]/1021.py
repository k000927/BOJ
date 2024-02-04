from collections import deque

n, m = map(int, input().split())
arr = list(map(int, input().split()))
dq = deque()

ans = 0

for n in range(n):
    dq.append(n + 1)

for num in arr:
    cnt = 0
    while True:
        if dq[0] == num:
            ans += min(cnt, len(dq) - cnt)
            dq.popleft()
            break
        else:
            dq.append(dq.popleft())
            cnt += 1

print(ans)
