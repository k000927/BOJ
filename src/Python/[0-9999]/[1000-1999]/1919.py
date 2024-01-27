import sys

input = sys.stdin.readline
alphaA = [0 for _ in range(26)]
alphaB = [0 for _ in range(26)]

a = input().strip()
b = input().strip()
ans = 0

for c in a:
    alphaA[ord(c) - 97] += 1
for c in b:
    alphaB[ord(c) - 97] += 1
for i in range(26):
    ans += abs(alphaA[i] - alphaB[i])

print(ans)
