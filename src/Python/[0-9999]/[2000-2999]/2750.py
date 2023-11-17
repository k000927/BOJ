N = int(input())
arr = []
for i in range(0, N, 1):
    arr.append(int(input()))
arr.sort()
for i in range(0, N, 1):
    print(arr[i])