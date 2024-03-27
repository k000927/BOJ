import sys

sys.setrecursionlimit(10 ** 9)
input = sys.stdin.readline

N = int(input())
expression = input().strip()
ans = -sys.maxsize


def bfs(exp, idx):
    global expression
    global ans
    if idx >= N:
        ans = max(ans, eval(exp))
        return
    if idx % 2 == 1:
        bfs(exp + expression[idx], idx + 1)
    else:
        if idx + 3 <= N:
            bfs(exp + "(" + expression[idx:idx + 3] + ")", idx + 3)
        bfs(exp + expression[idx], idx + 1)


bfs("", 0)

print(ans)
