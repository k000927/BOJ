T = int(input())
for i in range(0, T, 1):
    A = input().split()
    ans = float(A[0])
    for j in range(1, len(A), 1):
        if A[j] == '@':
            ans *= 3
        elif A[j] == '%':
            ans += 5
        else: ans -= 7
    print("%.2f" % (ans))