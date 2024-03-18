from itertools import combinations

h, w = map(int, input().split())
n = int(input())
stickers = [list(map(int, input().split())) for _ in range(n)]

stickers_comb = list(combinations(range(n), 2))

ans = 0

for sticker in stickers_comb:
    one = sticker[0]
    two = sticker[1]
    for i in range(2):
        for j in range(2):
            one_h = stickers[one][i]
            one_w = stickers[one][(i + 1) % 2]
            two_h = stickers[two][j]
            two_w = stickers[two][(j + 1) % 2]
            if one_h > h or two_h > h or one_w > w or two_w > w:
                continue
            if one_h + two_h > h:
                if one_w + two_w <= w:
                    ans = max(one_h * one_w + two_h * two_w, ans)
            else:
                if max(one_w, two_w) <= w:
                    ans = max(one_h * one_w + two_h * two_w, ans)

print(ans)
