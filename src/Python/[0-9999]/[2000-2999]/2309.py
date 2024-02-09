from itertools import combinations

dwarf = []

for _ in range(9):
    dwarf.append(int(input()))

seven = combinations(dwarf, 7)
for d in seven:
    if sum(d) == 100:
        ans = list(d)
        break
ans.sort()
for d in ans:
    print(d)
