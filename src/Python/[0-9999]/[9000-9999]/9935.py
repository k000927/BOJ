import sys

input = sys.stdin.readline

string = input().strip()
explode = input().strip()

stack = []
ex_len = len(explode)

for i in range(len(string)):
    stack.append(string[i])
    if "".join(stack[-ex_len:]) == explode:
        for _ in range(ex_len):
            stack.pop()

if stack:
    print("".join(stack))
else:
    print("FRULA")
