from itertools import combinations

n, l, r, x = map(int, input().split())
A = list(map(int, input().split()))
A.sort()

ans = 0

for i in range(2, n + 1):
    problem_comb = list(combinations(A, i))
    for problem in problem_comb:
        pSum = sum(problem)
        if l <= pSum <= r:
            if problem[-1] - problem[0] >= x:
                ans += 1

print(ans)
