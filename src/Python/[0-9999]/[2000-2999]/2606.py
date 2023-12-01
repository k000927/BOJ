from collections import deque

com = int(input())
graph = [[] for _ in range(com + 1)]
visited = [False for _ in range(com + 1)]

for _ in range(int(input())):
    n, m = map(int, input().split())
    graph[n].append(m)
    graph[m].append(n)

count = -1
queue = deque([1])
visited[1] = True
while queue:
    x = queue.popleft()
    count += 1
    for i in graph[x]:
        if not visited[i]:
            queue.append(i)
            visited[i] = True

print(count)
