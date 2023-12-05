import sys

t = int(input())

for _ in range(t):
    n = int(input())
    arr = []
    top = 0
    for _ in range(n):
        isAdd = True
        name, cloth = map(str, sys.stdin.readline().strip().split())
        for i in range(len(arr)):
            if arr[i][0] == cloth:
                arr[i][1] += 1
                isAdd = False
        if isAdd:
            arr.append([cloth, 1])
    if len(arr) == 1:
        print(arr[0][1])
    else:
        sum = 1
        for i in range(len(arr)):
            sum *= arr[i][1] + 1
        print(sum - 1)
