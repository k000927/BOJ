import sys
from heapq import heappush, heappop

input = sys.stdin.readline
n, e = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))

v1, v2 = map(int, input().split())

dp = [sys.maxsize] * (n + 1)
heap = []


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


ans1 = 0
ans2 = 0

dijkstra(1)

if dp[v1] == sys.maxsize:
    ans1 = -1
else:
    ans1 += dp[v1]
if dp[v2] == sys.maxsize:
    ans2 = -1
else:
    ans2 += dp[v2]

dp = [sys.maxsize] * (n + 1)
dijkstra(v1)
if dp[v2] == sys.maxsize:
    ans1 = -1
else:
    ans1 += dp[v2]
dp = [sys.maxsize] * (n + 1)
dijkstra(v2)
if dp[v1] == sys.maxsize:
    ans2 = -1
else:
    ans2 += dp[v1]

dp = [sys.maxsize] * (n + 1)
dijkstra(v2)
if dp[n] == sys.maxsize:
    ans1 = -1
else:
    ans1 += dp[n]

dp = [sys.maxsize] * (n + 1)
dijkstra(v1)
if dp[n] == sys.maxsize:
    ans2 = -1
else:
    ans2 += dp[n]

if ans1 == -1 and ans2 == -1:
    print(-1)
elif ans1 != -1 and ans2 != -1:
    print(min(ans1, ans2))
else:
    print(max(ans1, ans2))
