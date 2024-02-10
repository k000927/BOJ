from collections import deque

n, m = map(int, input().split())


visited = [False for _ in range(n)]


def dfs(queue):
    if len(queue) == m:
        print(" ".join(queue))
        return
    else:
        for i in range(1, n + 1):
            queue.append(str(i))
            dfs(queue)
            queue.pop()


dfs(deque())
