n, x = map(int, input().split())
height = [0 for _ in range(51)]
patty = [0 for _ in range(51)]
height[0] = 1
patty[0] = 1
for i in range(1, 51):
    height[i] = 3 + height[i - 1] * 2
    patty[i] = 1 + patty[i - 1] * 2


def getPatty(n, x):
    if x == height[n]:  # 전체를 먹은 경우
        return patty[n]
    elif x == 1:  # 맨 아래 번만 먹은 경우
        return 0
    elif x == 2 + height[n - 1]:  # 패티 + n-1버거 + 번을 먹은 경우
        return patty[n - 1] + 1
    elif 1 < x < 2 + height[n - 1]:  # n-1 버거의 일부분 + 번을 먹은 경우
        return getPatty(n - 1, x - 1)
    else:
        return patty[n - 1] + getPatty(n - 1, x - height[n - 1] - 2) + 1  # n-1 버거의 일부분 + 패티 + n-1 버거 + 번을 먹은 경우


print(getPatty(n, x))
