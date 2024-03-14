import sys

dx = [0, 0, 0, -1, 1]
dy = [0, 1, -1, 0, 0]

n, k = map(int, sys.stdin.readline().strip().split())

board = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(n)]

record = [[[] for _ in range(n)] for _ in range(n)]

horses_info = [[] for _ in range(k + 1)]
for i in range(1, k + 1):
    r, c, dir = map(int, sys.stdin.readline().strip().split())
    horses_info[i] = [i, r - 1, c - 1, dir]
    record[r - 1][c - 1].append(i)


def is_bottom_horse(h_num, x, y):
    horse_state = record[x][y]
    if horse_state[0] == h_num:
        return True
    else:
        return False


def reverse_dir(dir):
    if dir == 1:
        return 2
    elif dir == 2:
        return 1
    elif dir == 3:
        return 4
    else:
        return 3


def is_blue_again(x, y, dir):
    rev_dir = reverse_dir(dir)
    nnx = x + dx[rev_dir]
    nny = y + dy[rev_dir]

    if nnx < 0 or nny < 0 or nnx >= n or nny >= n or board[nnx][nny] == 2:
        return True
    return False


def move_next_pos(x, y, dir):
    nx = x + dx[dir]
    ny = y + dy[dir]

    if nx < 0 or ny < 0 or nx >= n or ny >= n or board[nx][ny] == 2:
        if is_blue_again(x, y, dir):
            return x, y, reverse_dir(dir)
        else:
            rev_dir = reverse_dir(dir)
            return move_next_pos(x, y, rev_dir)

    elif board[nx][ny] == 1:
        rev_horses = record[x][y][::-1]
        for value in rev_horses:
            record[nx][ny].append(value)
            h_n, x, y, d = horses_info[value]
            horses_info[value] = [h_n, nx, ny, d]
        record[x][y] = []

    elif board[nx][ny] == 0:
        for value in record[x][y]:
            record[nx][ny].append(value)
            h_n, x, y, d = horses_info[value]
            horses_info[value] = [h_n, nx, ny, d]
        record[x][y] = []

    return nx, ny, dir


def move_all_horses():
    for horse in range(1, k + 1):
        horse_num, r, c, dir = horses_info[horse]
        if not is_bottom_horse(horse_num, r, c):
            continue

        nx, ny, n_dir = move_next_pos(r, c, dir)
        horses_info[horse_num] = [horse_num, nx, ny, n_dir]


def is_finish():
    for i in range(n):
        for j in range(n):
            if len(record[i][j]) >= 4:
                return True
    return False


ans = -1
time = 1
while time <= 1000:
    move_all_horses()

    if is_finish():
        ans = time
        break

    time += 1

print(ans)
