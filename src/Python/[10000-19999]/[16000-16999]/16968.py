numberBoard = input()

curX = "x"

ans = 1

for x in numberBoard:
    if x == "d":
        if x == curX:
            ans *= 9
        else:
            ans *= 10
    else:
        if x == curX:
            ans *= 25
        else:
            ans *= 26
    curX = x

print(ans)
