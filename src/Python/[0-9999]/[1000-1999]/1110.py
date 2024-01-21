origin = input()
ans = 1


def func(n):
    if int(n) < 10:
        n = "0" + n
    temp = str(int(n[0]) + int(n[1]))
    if int(temp) < 10:
        temp = "0" + temp
    return str(int(n[1] + temp[1]))


n = func(origin)
while True:
    if n == origin:
        print(ans)
        break
    else:
        n = func(n)
        ans += 1
