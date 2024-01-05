import sys
from heapq import heappop, heappush

input = sys.stdin.readline
INF = sys.maxsize

n, m, x = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, t = map(int, input().split())
    graph[a].append((t, b))


disToX = []

for i in range(1, n + 1):
    if i == x:
        disToX.append(0)
    else:
        dis = [INF for _ in range(n + 1)]
        queue = [(0, i)]
        dis[i] = 0
        while queue:
            (d, node) = heappop(queue)
            if dis[node] < d:
                continue
            for value, next_node in graph[node]:
                cost = dis[node] + value
                if cost < dis[next_node]:
                    dis[next_node] = cost
                    heappush(queue, (value, next_node))
        disToX.append(dis[x])


dis = [INF for _ in range(n + 1)]
queue = [(0, x)]
dis[x] = 0
while queue:
    (d, node) = heappop(queue)
    if dis[node] < d:
        continue
    for value, next_node in graph[node]:
        cost = dis[node] + value
        if cost < dis[next_node]:
            dis[next_node] = cost
            heappush(queue, (value, next_node))
disFromX = dis[1:]

max_time = disFromX[0] + disToX[0]
ans = 0
for idx in range(n):
    max_time = max(max_time, disFromX[idx] + disToX[idx])


print(max_time)
