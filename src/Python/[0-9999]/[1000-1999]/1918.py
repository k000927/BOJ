line = list(input())

stack = []

operator = ["+", "-", "*", "/"]

bracket = ["(", ")"]

for char in line:
    if char in operator:
        if len(stack) == 0:
            stack.append(char)
        else:
            if char == "+" or char == "-":
                while stack:
                    if stack[-1] == "(":
                        stack.append(char)
                        break
                    else:
                        print(stack.pop(), end="")
                if len(stack) == 0:
                    stack.append(char)
            else:
                while stack:
                    if stack[-1] == "(" or stack[-1] == "+" or stack[-1] == "-":
                        stack.append(char)
                        break
                    else:
                        print(stack.pop(), end="")
                if len(stack) == 0:
                    stack.append(char)
    elif char in bracket:
        if char == "(":
            stack.append(char)
        else:
            while stack[-1] != "(":
                print(stack.pop(), end="")
            stack.pop()
    else:
        print(char, end="")

for idx in range(len(stack) - 1, -1, -1):
    print(stack[idx], end="")

print()
