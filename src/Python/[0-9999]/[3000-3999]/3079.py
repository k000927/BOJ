N, M = map(int, input().split())
T = []

for _ in range(N):
    T.append(int(input()))

left = 0
right = 10 ** 20

while left < right:
    mid = (left + right) // 2
    temp = 0

    for t in T:
        temp += mid // t

    if temp >= M:
        right = mid
    else:
        left = mid + 1

print(left)
