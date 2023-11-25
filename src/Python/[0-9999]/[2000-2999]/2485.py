n = int(input())
arr = []
diff = []
for i in range(n):
    arr.append(int(input()))
for i in range(n - 1):
    diff.append(arr[i + 1] - arr[i])


def GCD(a, b):
    while b != 0:
        a, b = b, a % b
    return a


GCDarr = diff[0]
for i in range(len(diff)):
    GCDarr = GCD(GCDarr, diff[i])


ans = int((arr[-1] - arr[0]) / GCDarr + 1 - len(arr))
print(ans)
