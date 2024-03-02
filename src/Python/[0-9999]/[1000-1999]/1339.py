n = int(input())
sum = [0 for _ in range(26)]
for _ in range(n):
    num = input()
    for i in range(len(num)):
        sum[ord(num[i]) - 65] += 10 ** (len(num) - i - 1)
sum.sort(reverse=True)
ans = 0
i = 9
for n in sum:
    ans += n * i
    i -= 1
print(ans)
