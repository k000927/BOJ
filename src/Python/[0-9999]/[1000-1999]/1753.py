import sys
from heapq import heappop, heappush

input = sys.stdin.readline

v, e = map(int, input().split())
k = int(input())
dp = [sys.maxsize] * (v + 1)
heap = []
graph = [[] for _ in range(v + 1)]


for _ in range(e):
    a, b, w = map(int, input().split())
    graph[a].append((w, b))


def dijkstra(start):
    dp[start] = 0
    heappush(heap, (0, start))
    while heap:
        wei, now = heappop(heap)
        if dp[now] < wei:
            continue
        for w, next_node in graph[now]:
            next_wei = w + wei
            if next_wei < dp[next_node]:
                dp[next_node] = next_wei
                heappush(heap, (next_wei, next_node))


dijkstra(k)
for i in range(1, v + 1):
    print("INF" if dp[i] == sys.maxsize else dp[i])
