import sys
from copy import deepcopy

input = sys.stdin.readline

n = int(input())


minArr = []
maxArr = []

a, b, c = map(int, input().split())

minArr = [a, b, c]
maxArr = [a, b, c]
tempMin = [a, b, c]
tempMax = [a, b, c]

for _ in range(n - 1):
    a, b, c = map(int, input().split())
    minArr[0] = a + min(tempMin[0], tempMin[1])
    minArr[1] = b + min(tempMin[0], tempMin[1], tempMin[2])
    minArr[2] = c + min(tempMin[1], tempMin[2])
    maxArr[0] = a + max(tempMax[0], tempMax[1])
    maxArr[1] = b + max(tempMax[0], tempMax[1], tempMax[2])
    maxArr[2] = c + max(tempMax[1], tempMax[2])
    tempMin[0] = minArr[0]
    tempMin[1] = minArr[1]
    tempMin[2] = minArr[2]
    tempMax[0] = maxArr[0]
    tempMax[1] = maxArr[1]
    tempMax[2] = maxArr[2]

print(max(maxArr), min(minArr))
