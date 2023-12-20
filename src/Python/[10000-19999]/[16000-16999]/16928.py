import sys

n, m = map(int, sys.stdin.readline().strip().split())

graph = [0] * 101
visited = [False for _ in range(101)]

ladder = dict()
snake = dict()

for _ in range(n):
    a, b = map(int, input().split())
    ladder[a] = b

for _ in range(m):
    a, b = map(int, input().split())
    snake[a] = b

q = [1]

while q:
    x = q.pop(0)
    if x == 100:
        print(graph[x])
        break
    for dice in range(1, 7):
        next_place = dice + x
        if next_place <= 100 and not visited[next_place]:
            if next_place in ladder.keys():
                next_place = ladder[next_place]
            if next_place in snake.keys():
                next_place = snake[next_place]
            if not visited[next_place]:
                visited[next_place] = True
                graph[next_place] = graph[x] + 1
                q.append(next_place)
