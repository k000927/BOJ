import sys

exp = sys.stdin.readline().strip().split("-")


for idx in range(len(exp)):
    exp[idx] = list(map(int, exp[idx].split("+")))

ans = sum(exp[0])

for idx in range(1, len(exp)):
    ans -= sum(exp[idx])

print(ans)
