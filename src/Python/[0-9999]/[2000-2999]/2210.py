ans = set()
digit = [list(input().split()) for _ in range(5)]
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]


def back_tracking(i, j, num, cnt):
    if cnt == 6:
        ans.add(num)
        return
    for k in range(4):
        x = i + dx[k]
        y = j + dy[k]
        if x < 0 or x >= 5 or y < 0 or y >= 5:
            continue
        back_tracking(x, y, num + digit[x][y], cnt + 1)


for i in range(5):
    for j in range(5):
        back_tracking(i, j, digit[i][j], 1)

print(len(ans))
