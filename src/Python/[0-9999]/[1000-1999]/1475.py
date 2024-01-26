import math

n = input()
num = [0 for _ in range(10)]
for i in range(len(n)):
    num[int(n[i])] += 1

num[6] = math.ceil((num[6] + num[9]) / 2)
num[9] = num[6]

print(max(num))
