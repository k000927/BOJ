from itertools import combinations

l, c = map(int, input().split())
char = list(input().split())
ans = list(combinations(char, l))
result = []

for password in ans:
    vowels = 0
    cons = 0
    for ch in password:
        if ch == "a" or ch == "e" or ch == "i" or ch == "o" or ch == "u":
            vowels += 1
        else:
            cons += 1
    if vowels >= 1 and cons >= 2:
        p = list(password)
        p.sort()
        result.append("".join(p))

result.sort()
for a in result:
    print(a)
