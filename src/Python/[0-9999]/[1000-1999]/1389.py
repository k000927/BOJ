import sys
from heapq import heappush, heappop

inf = int(1e9)

n, m = map(int, sys.stdin.readline().strip().split())

graph = [[] for _ in range(n + 1)]
ans = 0
min = inf * n
distance = [[inf] * (n + 1) for _ in range(n + 1)]

for i in range(m):
    a, b = map(int, sys.stdin.readline().strip().split())
    graph[a].append((b, 1))
    graph[b].append((a, 1))


def djkstra(start):
    global distance, graph
    queue = []
    heappush(queue, (0, start))
    distance[start][start] = 0
    while queue:
        dist, now = heappop(queue)
        if distance[start][now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[start][i[0]]:
                distance[start][i[0]] = cost
                heappush(queue, (cost, i[0]))


for i in range(1, n + 1):
    djkstra(i)
    cur_sum = sum(distance[i][1:])
    if min > cur_sum:
        ans = i
        min = cur_sum

print(ans)
