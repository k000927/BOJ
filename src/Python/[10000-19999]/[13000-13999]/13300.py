import sys
import math

input = sys.stdin.readline

n, k = map(int, input().split())

stu = [[0, 0] for _ in range(6)]
ans = 0

for _ in range(n):
    gender, grade = map(int, input().split())
    stu[grade - 1][gender] += 1

for i in range(6):
    for j in range(2):
        ans += math.ceil(stu[i][j] / k)
print(ans)
