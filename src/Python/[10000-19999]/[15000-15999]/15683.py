from copy import deepcopy

n, m = map(int, input().split())
room = [list(input().split()) for _ in range(n)]
cctv = []

for i in range(n):
    for j in range(m):
        if room[i][j] == "0" or room[i][j] == "6":
            continue
        cctv.append([int(room[i][j]), i, j])

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

ans = n * m


def cctvf(i, j, dir, room):
    tempRoom = deepcopy(room)
    while 0 <= i < n and 0 <= j < m and tempRoom[i][j] != "6":
        if tempRoom[i][j] == "0":
            tempRoom[i][j] = "#"
        i += dx[dir]
        j += dy[dir]
    return tempRoom


def getBlind(room):
    temp = 0
    for i in range(n):
        for j in range(m):
            if room[i][j] == "0":
                temp += 1
    return temp


def backTracking(room, idx):
    global ans, cctv
    if idx == len(cctv):
        ans = min(getBlind(room), ans)
        return
    cctvNum = cctv[idx][0]
    x = int(cctv[idx][1])
    y = int(cctv[idx][2])
    if cctvNum == 1:
        for i in range(4):
            backTracking(cctvf(x, y, i, room), idx + 1)
    elif cctvNum == 2:
        backTracking(cctvf(x, y, 0, cctvf(x, y, 2, room)), idx + 1)
        backTracking(cctvf(x, y, 1, cctvf(x, y, 3, room)), idx + 1)
    elif cctvNum == 3:
        backTracking(cctvf(x, y, 0, cctvf(x, y, 1, room)), idx + 1)
        backTracking(cctvf(x, y, 1, cctvf(x, y, 2, room)), idx + 1)
        backTracking(cctvf(x, y, 2, cctvf(x, y, 3, room)), idx + 1)
        backTracking(cctvf(x, y, 3, cctvf(x, y, 0, room)), idx + 1)
    elif cctvNum == 4:
        backTracking(cctvf(x, y, 0, cctvf(x, y, 1, cctvf(x, y, 2, room))), idx + 1)
        backTracking(cctvf(x, y, 0, cctvf(x, y, 1, cctvf(x, y, 3, room))), idx + 1)
        backTracking(cctvf(x, y, 0, cctvf(x, y, 3, cctvf(x, y, 2, room))), idx + 1)
        backTracking(cctvf(x, y, 3, cctvf(x, y, 1, cctvf(x, y, 2, room))), idx + 1)
    else:
        backTracking(cctvf(x, y, 0, cctvf(x, y, 1, cctvf(x, y, 2, cctvf(x, y, 3, room)))), idx + 1)


backTracking(room, 0)

print(ans)
