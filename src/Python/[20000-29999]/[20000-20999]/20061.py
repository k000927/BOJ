n = int(input())
blocks = [list(map(int, input().split())) for _ in range(n)]
blue = [[False for _ in range(6)] for _ in range(4)]
green = [[False for _ in range(4)] for _ in range(6)]

score = 0


def moveToBlue(t, x):
    if t == 1:
        for i in range(1, 6):
            if blue[x][i]:
                blue[x][i - 1] = True
                return
        blue[x][5] = True
    elif t == 2:
        for i in range(2, 6):
            if blue[x][i]:
                blue[x][i - 1] = True
                blue[x][i - 2] = True
                return
        blue[x][5] = True
        blue[x][4] = True
    else:
        for i in range(1, 6):
            if blue[x][i] or blue[x + 1][i]:
                blue[x][i - 1] = True
                blue[x + 1][i - 1] = True
                return
        blue[x][5] = True
        blue[x + 1][5] = True


def moveToGreen(t, y):
    tG = green
    if t == 1:
        for i in range(1, 6):
            if green[i][y]:
                green[i - 1][y] = True
                return
        green[5][y] = True
    elif t == 2:
        for i in range(1, 6):
            if green[i][y] or green[i][y + 1]:
                green[i - 1][y] = True
                green[i - 1][y + 1] = True
                return
        green[5][y] = True
        green[5][y + 1] = True
    else:
        for i in range(2, 6):
            if green[i][y]:
                green[i - 1][y] = True
                green[i - 2][y] = True
                return
        green[5][y] = True
        green[4][y] = True


def clearGreenLine():
    global green, score
    i = 5
    while i >= 0:
        if green[i] == [True, True, True, True]:
            score += 1
            green = [[False, False, False, False]] + green[:i] + green[i + 1:]
        else:
            i -= 1
    if True in green[1]:
        if True in green[0]:
            green = [[False, False, False, False]] + [[False, False, False, False]] + green[:4]
        else:
            green = [[False, False, False, False]] + green[:5]


def clearBlueLine():
    global blue, score
    tempBlue = []
    for i in range(6):
        tempBlue.append([blue[3][i], blue[2][i], blue[1][i], blue[0][i]])
    i = 5
    while i >= 0:
        if tempBlue[i] == [True, True, True, True]:
            score += 1
            tempBlue = [[False, False, False, False]] + tempBlue[:i] + tempBlue[i + 1:]
        else:
            i -= 1
    if True in tempBlue[1]:
        if True in tempBlue[0]:
            tempBlue = [[False, False, False, False]] + [[False, False, False, False]] + tempBlue[:4]
        else:
            tempBlue = [[False, False, False, False]] + tempBlue[:5]
    for i in range(4):
        blue[i] = [tempBlue[0][3 - i], tempBlue[1][3 - i], tempBlue[2][3 - i], tempBlue[3][3 - i], tempBlue[4][3 - i],
                   tempBlue[5][3 - i]]


for block in blocks:
    t, x, y = block[0], block[1], block[2]
    moveToBlue(t, x)
    moveToGreen(t, y)
    clearBlueLine()
    clearGreenLine()

blocks = 0
for i in range(4):
    for j in range(6):
        if blue[i][j]:
            blocks += 1
        if green[j][i]:
            blocks += 1

print(score)
print(blocks)
