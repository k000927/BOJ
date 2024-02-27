T = int(input())
gear = [list(map(int, list(input()))) for _ in range(T)]
k = int(input())
ops = [list(map(int, input().split())) for _ in range(k)]


def spin(gearN, dir):
    if dir == 1:
        gear[gearN] = [gear[gearN][-1]] + gear[gearN][:7]
    else:
        gear[gearN] = gear[gearN][1:] + [gear[gearN][0]]


for op in ops:
    gearN, dir = op
    gearN -= 1
    dirA = 1 if dir == 1 else -1
    dirB = 1 if dir == 1 else -1
    queue = [(gearN, dir)]
    for n in range(gearN, T - 1):
        if gear[n][2] != gear[n + 1][6]:
            dirA *= -1
            queue.append((n + 1, dirA))
        else:
            break
    for n in range(gearN - 1, -1, -1):
        if gear[n][2] != gear[n + 1][6]:
            dirB *= -1
            queue.append((n, dirB))
        else:
            break
    for s in queue:
        gearN, dir = s
        spin(gearN, dir)

ans = 0
for g in gear:
    if g[0]:
        ans += 1
print(ans)
