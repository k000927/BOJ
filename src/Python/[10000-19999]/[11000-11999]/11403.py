import sys

n = int(sys.stdin.readline().strip())

graph = [[] for _ in range(n)]
visited = [["0" for _ in range(n)] for _ in range(n)]
for i in range(n):
    arr = list(map(int, sys.stdin.readline().strip().split()))
    for idx in range(len(arr)):
        if arr[idx]:
            graph[i].append(idx)


for i in range(n):
    queue = []
    queue.append(i)
    while queue:
        x = queue.pop(0)
        for node in graph[x]:
            if visited[i][node] != "1":
                queue.append(node)
                visited[i][node] = "1"

for i in range(n):
    print(" ".join(visited[i]))
