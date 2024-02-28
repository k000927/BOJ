n = int(input())
graph = [[False for _ in range(101)] for _ in range(101)]
ans = 0
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]


def getDragon(queue, g):
    curG = 0
    while curG < g:
        tempQ = queue[::-1]
        for dir in tempQ:
            queue.append(dir + 1 if dir < 3 else 0)
        curG += 1
    return queue


for _ in range(n):
    x, y, d, g = map(int, input().split())
    ops = getDragon([d], g)
    graph[x][y] = True
    for op in ops:
        x += dx[op]
        y += dy[op]
        graph[x][y] = True

for i in range(100):
    for j in range(100):
        if graph[i][j] and graph[i + 1][j] and graph[i][j + 1] and graph[i + 1][j + 1]:
            ans += 1

print(ans)
