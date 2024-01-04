import sys

input = sys.stdin.readline
INF = sys.maxsize

n = int(input())
m = int(input())

graph = [[INF for _ in range(n + 1)] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)

for idx in range(n + 1):
    graph[idx][0] = 0
    graph[0][idx] = 0
    graph[idx][idx] = 0

for mid in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            graph[i][j] = min(graph[i][j], graph[i][mid] + graph[mid][j])


for idx in range(1, n + 1):
    ans = ""
    for num in graph[idx][1:]:
        if num == INF:
            ans += "0 "
        else:
            ans += str(num) + " "
    print(ans)
