n = int(input())

w = [list(map(int, input().split())) for _ in range(n)]
visited = [False for _ in range(n)]

ans = 10**9


def back_tracking(queue, visited, cost):
    global ans
    if len(queue) == n:
        if w[queue[-1]][queue[0]] != 0:
            ans = min(ans, cost + w[queue[-1]][queue[0]])
        return
    else:
        for node in range(n):
            if not visited[node] and w[queue[-1]][node] != 0:
                visited[node] = True
                back_tracking(queue + [node], visited, cost + w[queue[-1]][node])
                visited[node] = False


visited[0] = True
back_tracking([0], visited, 0)
print(ans)
