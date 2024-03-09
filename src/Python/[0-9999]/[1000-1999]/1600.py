from collections import deque

k = int(input())
w, h = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(h)]
visited = [[[False for _ in range(k + 1)] for _ in range(w)] for _ in range(h)]
Q = deque()
Q.append((0, 0, 0, k))
visited[0][0][k] = True

monkey_x = [0, 0, -1, 1]
monkey_y = [1, -1, 0, 0]
horse_x = [-2, -1, 1, 2, 2, 1, -1, -2]
horse_y = [1, 2, 2, 1, -1, -2, -2, -1]

while Q:
    i, j, cnt, leftHorse = Q.popleft()
    if i == h - 1 and j == w - 1:
        print(cnt)
        exit()
    for k in range(4):
        x = i + monkey_x[k]
        y = j + monkey_y[k]
        if (
            0 <= x < h
            and 0 <= y < w
            and map[x][y] != 1
            and not visited[x][y][leftHorse]
        ):
            visited[x][y][leftHorse] = True
            Q.append((x, y, cnt + 1, leftHorse))
    if leftHorse == 0:
        continue
    for k in range(8):
        x = i + horse_x[k]
        y = j + horse_y[k]
        if (
            0 <= x < h
            and 0 <= y < w
            and map[x][y] != 1
            and not visited[x][y][leftHorse - 1]
        ):
            visited[x][y][leftHorse - 1] = True
            Q.append((x, y, cnt + 1, leftHorse - 1))

print(-1)
