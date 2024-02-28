n, m = map(int, input().split())
r, c, d = map(int, input().split())

room = [list(map(int, input().split())) for _ in range(n)]
# 0: 청소되지 않은 빈칸, 1: 벽, 2: 청소한 빈 칸
ans = 0
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def search(r, c):
    global room
    for i in range(4):
        x = r + dx[i]
        y = c + dy[i]
        if 0 <= x < n and 0 <= y < m and room[x][y] == 0:
            return True
    return False


while True:
    if room[r][c] == 0:
        ans += 1
        room[r][c] = 2
    if not search(r, c):
        if d == 0:
            if room[r + 1][c] != 1:
                r += 1
            else:
                break
        elif d == 1:
            if room[r][c - 1] != 1:
                c -= 1
            else:
                break
        elif d == 2:
            if room[r - 1][c] != 1:
                r -= 1
            else:
                break
        else:
            if room[r][c + 1] != 1:
                c += 1
            else:
                break
    else:
        d = d - 1 if d - 1 >= 0 else 3
        if d == 0:
            if r - 1 >= 0 and room[r - 1][c] == 0:
                r -= 1
        elif d == 1:
            if c + 1 < m and room[r][c + 1] == 0:
                c += 1
        elif d == 2:
            if r + 1 < n and room[r + 1][c] == 0:
                r += 1
        else:
            if c - 1 >= 0 and room[r][c - 1] == 0:
                c -= 1

print(ans)
