n, m = map(int, input().split())
friend = [[] for _ in range(n)]
visited = [False for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    friend[a].append(b)
    friend[b].append(a)


def dfs(queue, visited):
    global friend
    if len(queue) == 5:
        print(1)
        exit()
    else:
        a = queue[-1]
        for b in friend[a]:
            if visited[b]:
                continue
            visited[b] = True
            dfs(queue + [b], visited)
            visited[b] = False


for i in range(n):
    visited[i] = True
    dfs([i], visited)
    visited[i] = False

print(0)
