n = int(input())
w = list(map(int, input().split()))
ans = -1


def dfs(queue, energy):
    global ans
    if len(queue) == 2:
        ans = max(energy, ans)
    else:
        for i in range(1, len(queue) - 1):
            dfs(queue[:i] + queue[i + 1 :], energy + queue[i - 1] * queue[i + 1])


dfs(w, 0)

print(ans)
