n, k = map(int, input().split())
zero_dur = 0
A = list(map(int, input().split()))
robot = [False for _ in range(n)]
ans = 0

while True:
    ans += 1
    A = [A[-1]] + A[:-1]
    robot = [False] + robot[:-1]
    if robot[-1]:
        robot[-1] = False
    for i in range(n - 1, 0, -1):
        if not robot[i - 1] or robot[i] or A[i] == 0:
            continue
        else:
            robot[i - 1] = False
            robot[i] = True
            A[i] -= 1
            if A[i] == 0:
                zero_dur += 1
    if A[0] != 0:
        robot[0] = True
        A[0] -= 1
        if A[0] == 0:
            zero_dur += 1
    if zero_dur >= k:
        print(ans)
        break
