import sys

a, b = map(int, input().split())

ans = sys.maxsize


def dfs(cnt, num):
    global ans
    if num > b:
        return
    elif num == b:
        ans = min(cnt, ans)
    else:
        dfs(cnt + 1, num * 2)
        dfs(cnt + 1, int(str(num) + "1"))


dfs(1, a)
if ans == sys.maxsize:
    print(-1)
else:
    print(ans)
