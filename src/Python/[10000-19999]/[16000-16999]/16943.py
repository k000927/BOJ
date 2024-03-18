from itertools import permutations

a, b = map(str, input().split())

c_perm = list(permutations(a, len(a)))

ans = -1

for c in c_perm:
    if c[0] == "0":
        continue
    intC = int("".join(c))
    if intC > int(b):
        continue
    else:
        ans = max(ans, intC)

print(ans)
