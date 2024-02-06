n = int(input())
ans = 0


def stacking(s):
    A = 0
    B = 0
    stack = []
    for c in s:
        if c == "A":
            if A == 0 or len(stack) == 0:
                stack.append(c)
                A += 1
            else:
                C = stack.pop()
                if C == "A":
                    A -= 1
                else:
                    stack.append("B")
                    stack.append("A")
                    A += 1
        else:
            if B == 0 or len(stack) == 0:
                stack.append(c)
                B += 1
            else:
                C = stack.pop()
                if C == "B":
                    B -= 1
                else:
                    stack.append("A")
                    stack.append("B")
                    B += 1
    if stack:
        return False
    else:
        return True


for _ in range(n):
    s = input()
    if stacking(s):
        ans += 1

print(ans)
