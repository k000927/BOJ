n = int(input())
building = []
for _ in range(n):
    building.append(int(input()))

ans = 0
stack = []


for idx in range(len(building)):
    while len(stack) != 0:
        if building[idx] < stack[-1][0]:
            break
        a, b = stack.pop()
        ans += (idx - 1) - b
    stack.append((building[idx], idx))

while stack:
    a, b = stack.pop()
    ans += n - b - 1

print(ans)
