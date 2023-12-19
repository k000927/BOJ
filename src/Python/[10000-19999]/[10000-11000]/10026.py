import sys

n = int(input())
graph = []
graph_jrsy = [[] for _ in range(n)]
visited_normal = [[False for _ in range(n)] for _ in range(n)]
visited_jrsy = [[False for _ in range(n)] for _ in range(n)]
cnt_normal = 0
cnt_jrsy = 0

for _ in range(n):
    graph.append(sys.stdin.readline().strip())

for x in range(n):
    for y in range(n):
        if graph[x][y] == "G":
            graph_jrsy[x].append("R")
        else:
            graph_jrsy[x].append(graph[x][y])


def getNext(visited):
    global n
    for x in range(n):
        for y in range(n):
            if visited[x][y] == False:
                return (x, y)
    return (-1, -1)


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

queue = []
local_cnt = 0
while local_cnt < n * n:
    (x, y) = getNext(visited_normal)
    queue.append((x, y))
    while queue:
        (x, y) = queue.pop(0)
        visited_normal[x][y] = True
        local_cnt += 1
        for idx in range(4):
            i = x + dx[idx]
            j = y + dy[idx]
            if (
                0 <= i
                and i < n
                and 0 <= j
                and j < n
                and graph[x][y] == graph[i][j]
                and visited_normal[i][j] == False
            ):
                queue.append((i, j))
                visited_normal[i][j] = True
    cnt_normal += 1


queue = []
local_cnt = 0
while local_cnt < n * n:
    (x, y) = getNext(visited_jrsy)
    queue.append((x, y))
    while queue:
        (x, y) = queue.pop(0)
        visited_jrsy[x][y] = True
        local_cnt += 1
        for idx in range(4):
            i = x + dx[idx]
            j = y + dy[idx]
            if (
                0 <= i
                and i < n
                and 0 <= j
                and j < n
                and graph_jrsy[x][y] == graph_jrsy[i][j]
                and visited_jrsy[i][j] == False
            ):
                queue.append((i, j))
                visited_jrsy[i][j] = True
    cnt_jrsy += 1


print(cnt_normal, cnt_jrsy)
