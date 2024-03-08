import sys

input = sys.stdin.readline


def DFS(L, node):
    if visited[node]:
        return 0
    visited[node] = True
    depth[node] = L
    for next_node in graph[node]:
        if not visited[next_node]:
            children[node] += DFS(L + 1, next_node) + 1
    return children[node]


N = int(input())
graph = [[] for _ in range(N)]
children = [0] * N
depth = [0] * N
visited = [False] * N
for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a - 1].append(b - 1)
    graph[b - 1].append(a - 1)

request = list(map(int, input().split()))

DFS(0, 0)

is_DFS = True

for i in range(N):
    if i == 0:
        if request[i] != 1:
            is_DFS = False
            break
        else:
            continue
    node = request[i] - 1
    sibling = i + children[node] + 1

    if sibling < N:
        sibling_node = request[sibling] - 1
        if depth[sibling_node] > depth[node]:
            is_DFS = False
            break

print(1 if is_DFS else 0)
