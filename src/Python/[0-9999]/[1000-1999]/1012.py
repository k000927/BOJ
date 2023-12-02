import sys

t = int(input())


def bfs(BCB, visited, graph, idx):
    global count
    if visited[idx] or not BCB[idx]:
        return
    else:
        queue = [idx]
        visited[idx] = True
        while queue:
            x = queue.pop()
            for i in graph[x]:
                if not visited[i]:
                    queue.append(i)
                    visited[i] = True
        count += 1


for _ in range(t):
    m, n, k = map(int, input().split())
    count = 0
    BCB = [False for _ in range(m * n)]
    graph = [[] for _ in range(m * n)]
    visited = [False for _ in range(m * n)]

    for q in range(k):
        i, j = map(int, sys.stdin.readline().strip().split())
        BCB[i + m * j] = True

    for idx in range(n * m):
        if not BCB[idx]:
            continue
        if idx % m == 0:
            if BCB[idx + 1]:
                graph[idx].append(idx + 1)
        elif idx % m == m - 1:
            if BCB[idx - 1]:
                graph[idx].append(idx + -1)
        else:
            if BCB[idx + 1]:
                graph[idx].append(idx + 1)
            if BCB[idx - 1]:
                graph[idx].append(idx + -1)
        if idx < m:
            if BCB[idx + m]:
                graph[idx].append(idx + m)
        elif idx >= (n - 1) * m:
            if BCB[idx - m]:
                graph[idx].append(idx - m)
        else:
            if BCB[idx + m]:
                graph[idx].append(idx + m)
            if BCB[idx - m]:
                graph[idx].append(idx - m)

    for idx in range(n * m):
        bfs(BCB, visited, graph, idx)

    print(count)
