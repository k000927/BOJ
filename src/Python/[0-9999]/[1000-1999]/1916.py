import sys
from heapq import heappush, heappop

INF = sys.maxsize
input = sys.stdin.readline

n = int(input())
m = int(input())
dp = [INF] * (n + 1)
heap = []
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))


a, b = map(int, input().split())


def dijkstra(start):
    dp[start] = 0
    heappush(heap, (0, start))
    while heap:
        value, cur_node = heappop(heap)
        if dp[cur_node] < value:
            continue
        for next_value, next_node in graph[cur_node]:
            v = value + next_value
            if v < dp[next_node]:
                dp[next_node] = v
                heappush(heap, (v, next_node))


dijkstra(a)
print(dp[b])
