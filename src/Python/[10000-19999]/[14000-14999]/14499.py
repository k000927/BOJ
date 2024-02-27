n, m, x, y, k = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(n)]
ops = list(map(int, input().split()))
dice = [0, 0, 0, 0, 0, 0]
bottom, top, left, right, up, down = (0, 5, 3, 2, 1, 4)


def east():
    global x, y, bottom, top, left, right, up, down
    y += 1
    if maps[x][y] == 0:
        maps[x][y] = dice[right]
    else:
        dice[right] = maps[x][y]
        maps[x][y] = 0
    bottom, top, left, right = right, left, bottom, top


def west():
    global x, y, bottom, top, left, right, up, down
    y -= 1
    if maps[x][y] == 0:
        maps[x][y] = dice[left]
    else:
        dice[left] = maps[x][y]
        maps[x][y] = 0
    bottom, top, left, right = left, right, top, bottom


def north():
    global x, y, bottom, top, left, right, up, down
    x -= 1
    if maps[x][y] == 0:
        maps[x][y] = dice[up]
    else:
        dice[up] = maps[x][y]
        maps[x][y] = 0
    bottom, top, up, down = up, down, top, bottom


def south():
    global x, y, bottom, top, left, right, up, down
    x += 1
    if maps[x][y] == 0:
        maps[x][y] = dice[down]
    else:
        dice[down] = maps[x][y]
        maps[x][y] = 0
    bottom, top, up, down = down, up, bottom, top


for op in ops:
    if op == 1:
        if y + 1 >= m:
            continue
        east()
    elif op == 2:
        if y - 1 < 0:
            continue
        west()
    elif op == 3:
        if x - 1 < 0:
            continue
        north()
    else:
        if x + 1 >= n:
            continue
        south()
    print(dice[top])
