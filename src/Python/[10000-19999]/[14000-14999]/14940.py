import sys

n, m = map(int, input().split())

visited = [[] for _ in range(n)]
graph = [[-1 for _ in range(m)] for _ in range(n)]
start_x = 0
start_y = 0
for i in range(n):
    arr = list(map(int, sys.stdin.readline().strip().split()))
    for j in range(len(arr)):
        if arr[j] == 2:
            start_x = i
            start_y = j
            visited[i].append(False)
        elif arr[j] == 1:
            visited[i].append(False)
        else:
            graph[i][j] = 0
            visited[i].append(True)


def printGraph(graph):
    for i in range(n):
        string = ""
        for j in range(m):
            string += str(graph[i][j])
            string += " "
        print(string)


queue = [(start_x, start_y)]
graph[start_x][start_y] = 0
while queue:
    (x, y) = queue.pop(0)
    visited[x][y] = True
    for i in [-1, 0, 1]:
        for j in [-1, 0, 1]:
            if (
                (i == j)
                or (i == -1 * j)
                or (x + i < 0 or x + i >= n)
                or (y + j < 0 or y + j >= m)
            ):
                continue
            else:
                if not visited[x + i][y + j]:
                    graph[x + i][y + j] = graph[x][y] + 1
                    visited[x + i][y + j] = True
                    queue.append((x + i, y + j))


printGraph(graph)
