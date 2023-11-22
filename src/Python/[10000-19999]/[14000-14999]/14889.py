import sys

N = int(input())
ans = sys.maxsize
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
visit = [False for _ in range(N)]


def backTracking(depth, idx):
    global ans
    if depth == N // 2:
        power1, power2 = 0, 0
        for i in range(N):
            for j in range(N):
                if visit[i] and visit[j]:
                    power1 += arr[i][j]
                elif not visit[i] and not visit[j]:
                    power2 += arr[i][j]
        ans = min(ans, abs(power1 - power2))
        return

    for i in range(idx, N):
        if not visit[i]:
            visit[i] = True
            backTracking(depth + 1, i + 1)
            visit[i] = False


backTracking(0, 0)
print(ans)
