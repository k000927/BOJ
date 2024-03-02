n = int(input())
A = list(map(int, input().split()))
ops = list(map(int, input().split()))
minAns = 1000000000
maxAns = -1000000000


def dfs(idx, ans, add, sub, mul, div):
    global minAns, maxAns
    if idx == n:
        minAns = min(ans, minAns)
        maxAns = max(ans, maxAns)
    else:
        if add > 0:
            dfs(idx + 1, ans + A[idx], add - 1, sub, mul, div)
        if sub > 0:
            dfs(idx + 1, ans - A[idx], add, sub - 1, mul, div)
        if mul > 0:
            dfs(idx + 1, ans * A[idx], add, sub, mul - 1, div)
        if div > 0:
            if ans < 0:
                dfs(idx + 1, (-ans // A[idx] * -1), add, sub, mul, div - 1)
            else:
                dfs(idx + 1, ans // A[idx], add, sub, mul, div - 1)


dfs(1, A[0], ops[0], ops[1], ops[2], ops[3])

print(maxAns)
print(minAns)
