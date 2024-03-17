from itertools import combinations_with_replacement

arab = [1, 5, 10, 50]

n = int(input())

numbers = [False for _ in range(50 * 20 + 1)]

rome = list(combinations_with_replacement(arab, n))

for r in rome:
    numbers[sum(r)] = True

ans = 0

for n in numbers:
    if n:
        ans += 1

print(ans)
