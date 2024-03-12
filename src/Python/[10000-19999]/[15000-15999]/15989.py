arr = [1 for _ in range(10001)]

for i in range(2, 10001):
    arr[i] += arr[i - 2]

for i in range(3, 10001):
    arr[i] += arr[i - 3]

t = int(input())

for _ in range(t):
    print(arr[int(input())])
