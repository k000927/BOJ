import sys

n, m = map(int, input().split())
arr = list(map(int, sys.stdin.readline().strip().split()))
presum = [0]

for i in range(n):
    presum.append(presum[i] + arr[i])


for i in range(m):
    start, end = map(int, sys.stdin.readline().strip().split())
    print(presum[end] - presum[start - 1])
