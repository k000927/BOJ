n, m = map(int, input().split())
A = list(map(int, input().split())) + [0]

i, j = 0, 0
sum = A[i]
ans = 0

while j < n:
    if sum == m:
        ans += 1
        sum -= A[i]
        i += 1
        j += 1
        sum += A[j]
    elif sum > m:
        sum -= A[i]
        i += 1
    else:
        j += 1
        sum += A[j]
print(ans)
