import sys

n, m = map(int, sys.stdin.readline().strip().split())

graph = []
visited = [[False for _ in range(m)] for _ in range(n)]
count = 0

start_i = -1
start_j = -1
for i in range(n):
    graph.append(list(sys.stdin.readline().strip()))
    if "I" in graph[i]:
        start_i = i
        start_j = graph[i].index("I")

queue = []
queue.append((start_i, start_j))
while queue:
    (x, y) = queue.pop(0)
    if graph[x][y] == "P":
        count += 1
    if x == 0:
        if graph[x + 1][y] != "X" and not visited[x + 1][y]:
            queue.append((x + 1, y))
            visited[x + 1][y] = True
    elif x == n - 1:
        if graph[x - 1][y] != "X" and not visited[x - 1][y]:
            queue.append((x - 1, y))
            visited[x - 1][y] = True
    else:
        if graph[x + 1][y] != "X" and not visited[x + 1][y]:
            queue.append((x + 1, y))
            visited[x + 1][y] = True
        if graph[x - 1][y] != "X" and not visited[x - 1][y]:
            queue.append((x - 1, y))
            visited[x - 1][y] = True
    if y == 0:
        if graph[x][y + 1] != "X" and not visited[x][y + 1]:
            queue.append((x, y + 1))
            visited[x][y + 1] = True
    elif y == m - 1:
        if graph[x][y - 1] != "X" and not visited[x][y - 1]:
            queue.append((x, y - 1))
            visited[x][y - 1] = True
    else:
        if graph[x][y + 1] != "X" and not visited[x][y + 1]:
            queue.append((x, y + 1))
            visited[x][y + 1] = True
        if graph[x][y - 1] != "X" and not visited[x][y - 1]:
            queue.append((x, y - 1))
            visited[x][y - 1] = True

print("TT" if count == 0 else count)
