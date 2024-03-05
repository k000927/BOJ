n, s = map(int, input().split())
arr = list(map(int, input().split()))

ans = 100001
sum, start, end = 0, 0, 0

sum = arr[0]

while True:
    if sum >= s:
        ans = min(ans, end - start + 1)
        sum -= arr[start]
        start += 1
    else:
        if end < n - 1:
            end += 1
            sum += arr[end]
        else:
            break

print(ans if ans != 100001 else 0)
