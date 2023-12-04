n, r, c = map(int, input().split())

ans = 0
x = 0
y = 0
w = 2**n
while True:
    if x == c and y == r and w == 0:
        print(ans)
        break
    elif c < x + w // 2:
        if r >= y + w // 2:
            ans += (w // 2) ** 2 * 2
            y += w // 2
    else:
        if r < y + w / 2:
            ans += (w // 2) ** 2
            x += w // 2
        else:
            ans += (w // 2) ** 2 * 3
            x += w // 2
            y += w // 2
    w = w // 2
