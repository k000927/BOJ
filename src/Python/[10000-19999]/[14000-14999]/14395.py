from collections import deque

s, t = map(int, input().split())
if s == t:
    print(0)
    exit()
if t == 0:
    print("-")
    exit()
queue = deque()
queue.append((s, ""))
one = False

while queue:
    n, ops = queue.popleft()
    if n == t:
        print(ops)
        exit()
    if n * n <= t and n != 1:
        queue.append((n * n, ops + "*"))
    if n + n <= t:
        queue.append((n + n, ops + "+"))
    if n != 0 and not one:
        queue.append((1, ops + "/"))
        one = True

print(-1)
