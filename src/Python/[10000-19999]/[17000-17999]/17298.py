n = int(input())
arr = list(map(int, input().split()))
stack = [0]
ans = []
for idx in range(len((arr[1:]))):
    while len(stack) != 0 and arr[idx + 1] > arr[stack[-1]]:
        i = stack.pop()
        ans.append((i, idx + 1))
    stack.append(idx + 1)

for i in stack:
    ans.append((i, -1))
ans.sort()

for a, b in ans:
    if b == -1:
        print(-1, end=" ")
    else:
        print(arr[b], end=" ")
print()
