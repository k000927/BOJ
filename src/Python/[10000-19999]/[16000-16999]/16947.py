import sys

sys.setrecursionlimit(10**9)

n = int(input())
graph = [[] for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]
visitedGraph = [[False for _ in range(n + 1)] for _ in range(n + 1)]
isCircular = [-1 for _ in range(n + 1)]
flag = False
for _ in range(n):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(queue, visited, visitedGraph):
    global flag
    if flag:
        return
    curStation = queue[-1]
    for adjStation in graph[curStation]:
        if visited[adjStation] and not visitedGraph[curStation][adjStation]:
            flag = True
            isCircular[adjStation] = 0
            for c in queue[::-1]:
                if c == adjStation:
                    break
                else:
                    isCircular[c] = 0
        elif not visited[adjStation]:
            visited[adjStation] = True
            visitedGraph[adjStation][curStation] = True
            visitedGraph[curStation][adjStation] = True
            dfs(queue + [adjStation], visited, visitedGraph)
            visited[adjStation] = False
            visitedGraph[adjStation][curStation] = False
            visitedGraph[curStation][adjStation] = False


for i in range(n + 1):
    if flag:
        break
    visited[i] = True
    dfs([i], visited, visitedGraph)
    visited[i] = False


def getDis(queue, visited, cnt):
    if isCircular[queue[-1]] == 0:
        isCircular[queue[0]] = cnt
    else:
        curStation = queue[-1]
        for adjStation in graph[curStation]:
            if visited[adjStation]:
                continue
            else:
                visited[adjStation] = True
                getDis(queue + [adjStation], visited, cnt + 1)
                visited[adjStation] = False


for i in range(n + 1):
    visited[i] = True
    getDis([i], visited, 0)
    visited[i] = False

print(" ".join(map(str, isCircular[1:])))
