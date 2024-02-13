n = int(input())
cons = [[]]
ans = 0


for _ in range(n):
    t, p = map(int, input().split())
    cons.append([t - 1, p])


def dfs(curDay, profit, consulting):
    global ans
    if curDay == n:
        if consulting is None:
            ans = max(profit, ans)
            return
        else:
            t, p = consulting
            if t == 0:
                profit += p
            ans = max(profit, ans)
            return
    if consulting is None:
        dfs(curDay + 1, profit, cons[curDay + 1])
        dfs(curDay + 1, profit, None)
    else:
        t, p = consulting
        if t != 0:
            dfs(curDay + 1, profit, (t - 1, p))
            return
        else:
            dfs(curDay + 1, profit + p, cons[curDay + 1])
            dfs(curDay + 1, profit + p, None)


dfs(0, 0, None)
print(ans)
