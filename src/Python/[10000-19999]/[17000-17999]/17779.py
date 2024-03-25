import sys

input = sys.stdin.readline
n = int(input())
city = [[0 for _ in range(n + 1)]] + [[0] + list(map(int, input().split())) for _ in range(n)]
ans = sys.maxsize

for x in range(1, n):
    for y in range(2, n):
        for d1 in range(1, n + 1):
            for d2 in range(1, n + 1):
                if x + d1 + d2 <= n and 1 <= y - d1 and y + d2 <= n:
                    area = [0, 0, 0, 0, 0]
                    for r in range(1, n + 1):
                        for c in range(1, n + 1):
                            if c >= -r + x + y and c <= r - x + y and c <= -r + x + y + 2 * d2 and c >= r - x + y - 2 * d1:
                                area[4] += city[r][c]
                            elif r < x + d1 and c <= y:
                                area[0] += city[r][c]
                            elif r <= x + d2 and y < c:
                                area[1] += city[r][c]
                            elif x + d1 <= r and c < y - d1 + d2:
                                area[2] += city[r][c]
                            elif x + d2 < r and y - d1 + d2 <= c:
                                area[3] += city[r][c]
                    ans = min(ans, max(area) - min(area))

print(ans)
