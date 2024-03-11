from collections import deque

f, s, g, u, d = map(int, input().split())
visited = [False for _ in range(f + 1)]

queue = deque()
queue.append((s, 0))
visited[s] = True

while queue:
    level, cnt = queue.popleft()
    if level == g:
        print(cnt)
        exit()
    if level + u <= f and not visited[level + u]:
        visited[level + u] = True
        queue.append((level + u, cnt + 1))
    if level - d >= 1 and not visited[level - d]:
        visited[level - d] = True
        queue.append((level - d, cnt + 1))

print("use the stairs")
