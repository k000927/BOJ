import sys

INF = int(1e9)
input = sys.stdin.readline

n, m, r = map(int, input().split())

values = [0] + [int(x) for x in sys.stdin.readline().split()]

graph = [[INF for _ in range(n + 1)] for _ in range(n + 1)]

for _ in range(r):
    a, b, l = map(int, input().split())
    graph[a][b] = l
    graph[b][a] = l

for idx in range(n + 1):
    graph[idx][idx] = 0

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

ans = 0
for i in range(1, n + 1):
    temp = 0
    for idx in range(1, n + 1):
        if graph[i][idx] <= m:
            temp += values[idx]
    ans = max(temp, ans)

print(ans)
