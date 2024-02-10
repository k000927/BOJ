n, m = map(int, input().split())
visited = [False for _ in range(n)]
ans = []
queue = []


def dfs(visited, queue):
    global ans
    if len(queue) == m:
        ans.append(list(queue))
        return
    else:
        for i in range(n):
            if not visited[i]:
                visited[i] = True
                queue.append(str(i + 1))
                dfs(visited, queue)
                visited[i] = False
                queue.pop()


dfs(visited, queue)
for num in ans:
    print(" ".join(num))
