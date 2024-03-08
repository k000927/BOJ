from collections import deque

A, B, C = map(int, input().split())
visited = [[False for _ in range(1501)] for _ in range(1501)]
queue = deque()
queue.append((A, B, C))
if (A + B + C) % 3 != 0:
    print(0)
    exit()

while queue:
    a, b, c = queue.popleft()
    if a == b and a == c:
        print(1)
        exit()
    else:
        if a < b:
            if b - a < 0 or visited[a + a][b - a]:
                continue
            queue.append((a + a, b - a, c))
            visited[a + a][b - a] = True
        if a < c:
            if c - a < 0 or visited[a + a][b]:
                continue
            queue.append((a + a, b, c - a))
            visited[a + a][b] = True
        if b < a:
            if a - b < 0 or visited[a - b][b + b]:
                continue
            queue.append((a - b, b + b, c))
            visited[a - b][b + b] = True
        if b < c:
            if c - b or visited[a][b + b]:
                continue
            queue.append((a, b + b, c - b))
            visited[a][b + b] = True
        if c < a:
            if a - c < 0 or visited[a - c][b]:
                continue
            queue.append((a - c, b, c + c))
            visited[a - c][b] = True
        if c < b:
            if b - c < 0 or visited[a][b - c]:
                continue
            queue.append((a, b - c, c + c))
            visited[a][b - c] = True

print(0)
