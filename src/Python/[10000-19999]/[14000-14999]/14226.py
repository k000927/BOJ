from collections import deque

s = int(input())
smile = [[False for _ in range(1001)] for _ in range(1001)]

queue = deque()
queue.append((1, 0, 0))

while queue:
    x, t, c = queue.popleft()
    if x == s:
        print(t)
        break
    else:
        if x > 0 and not smile[x - 1][c]:
            queue.append((x - 1, t + 1, c))
            smile[x - 1][c] = True
        if c != x:
            queue.append((x, t + 1, x))
        if c != 0 and x + c <= 1000 and not smile[x + c][c]:
            queue.append((x + c, t + 1, c))
            smile[x + c][c] = True
