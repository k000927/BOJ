from collections import deque

chess = [input() for _ in range(8)]

queue = deque()
queue.append((7, 0, chess, 0))

dx = [0, 0, 0, 1, 1, 1, -1, -1, -1]
dy = [-1, 1, 0, -1, 0, 1, -1, 0, 1]

while queue:
    i, j, curChess, cnt = queue.popleft()
    if cnt - i == 1:
        print(1)
        exit()
    if i == 0 and j == 7:
        print(1)
        exit()
    for k in range(9):
        x = i + dx[k]
        y = j + dy[k]
        if 0 <= x < 8 and 0 <= y < 8 and curChess[x][y] != "#":
            if x - 1 >= 0 and curChess[x - 1][y] == "#":
                continue
            queue.append((x, y, ["........"] + curChess[0:7], cnt + 1))


print(0)
