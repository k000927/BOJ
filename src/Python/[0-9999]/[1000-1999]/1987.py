import sys

input = sys.stdin.readline
r, c = map(int, input().split())

alpha = [False for _ in range(26)]
graph = []

for _ in range(r):
    graph.append(list(input().strip()))


dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

queue = [(0, 0)]
alpha[ord(graph[0][0]) - 65] = True
ans = 1


def dfs(queue, alpha, local_ans):
    global ans
    while queue:
        cur_x, cur_y = queue.pop(-1)
        for i in range(4):
            x = cur_x + dx[i]
            y = cur_y + dy[i]
            if x < 0 or x >= r or y < 0 or y >= c:
                continue
            if alpha[ord(graph[x][y]) - 65]:
                continue
            queue.append((x, y))
            alpha[ord(graph[x][y]) - 65] = True
            dfs(queue, alpha, local_ans + 1)
            alpha[ord(graph[x][y]) - 65] = False
    ans = max(ans, local_ans)


dfs(queue, alpha, ans)
print(ans)
