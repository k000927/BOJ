import sys
from copy import deepcopy

input = sys.stdin.readline

r, c, t = map(int, input().split())

graph = []
zero_graph = [[0 for _ in range(c)] for _ in range(r)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

for _ in range(r):
    graph.append(list(map(int, input().split())))

up = -1
down = -1
for i in range(r):
    if graph[i][0] == -1:
        up = i
        down = i + 1
        break


def mise(graph):
    next_graph = deepcopy(zero_graph)
    for i in range(r):
        for j in range(c):
            if graph[i][j] == 0:
                continue
            if graph[i][j] == -1:
                next_graph[i][j] = -1
                continue
            dir = 4
            for k in range(4):
                x = i + dx[k]
                y = j + dy[k]
                if x < 0 or x >= r or y < 0 or y >= c or graph[x][y] == -1:
                    dir -= 1
                    continue
                next_graph[x][y] += int(graph[i][j] / 5)
            next_graph[i][j] += graph[i][j] - int(graph[i][j] / 5) * dir
    return next_graph


def air_up():
    dx = [0, -1, 0, 1]
    dy = [1, 0, -1, 0]
    direct = 0
    before = 0
    x, y = up, 1
    while True:
        nx = x + dx[direct]
        ny = y + dy[direct]
        if x == up and y == 0:
            break
        if nx < 0 or nx >= r or ny < 0 or ny >= c:
            direct += 1
            continue
        graph[x][y], before = before, graph[x][y]
        x = nx
        y = ny


def air_down():
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    direct = 0
    before = 0
    x, y = down, 1
    while True:
        nx = x + dx[direct]
        ny = y + dy[direct]
        if x == down and y == 0:
            break
        if nx < 0 or nx >= r or ny < 0 or ny >= c:
            direct += 1
            continue
        graph[x][y], before = before, graph[x][y]
        x = nx
        y = ny


for i in range(t):
    graph = mise(graph)
    air_up()
    air_down()


ans = 0
for i in range(r):
    for j in range(c):
        if graph[i][j] == -1:
            continue
        else:
            ans += graph[i][j]
print(ans)
