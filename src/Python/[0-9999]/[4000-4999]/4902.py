import sys

input = sys.stdin.readline

idx = 1
while True:
    arr = list(map(int, input().split()))
    if arr[0] == 0:
        break
    n = arr[0]
    tri = []
    ans = -sys.maxsize
    for N in range(n):
        tridp = []
        sum = 0
        for i in range(N ** 2 + 1, (N + 1) ** 2 + 1):
            sum += arr[i]
            tridp.append(sum)
        tri.append(tridp)
    for i in range(n):
        for j in range(0, i * 2 + 1, 2):
            if j == 0:
                localAns = tri[i][j]
            else:
                localAns = tri[i][j] - tri[i][j - 1]
            ans = max(localAns, ans)
            for k in range(i + 1, n):
                if j == 0:
                    localAns += tri[k][j + (k - i) * 2]
                else:
                    localAns += tri[k][j + (k - i) * 2] - tri[k][j - 1]
                ans = max(localAns, ans)
    for i in range(n - 1, -1, -1):
        for j in range(1, i * 2 + 1, 2):
            localAns = tri[i][j] - tri[i][j - 1]
            for k in range(i - 1, -1, -1):
                if len(tri[k]) <= j or j - (i - k) * 2 - 1 < 0:
                    ans = max(localAns, ans)
                    break
                localAns += tri[k][j] - tri[k][j - (i - k) * 2 - 1]
                ans = max(localAns, ans)
    print(f"{idx}. {ans}")
    idx += 1
