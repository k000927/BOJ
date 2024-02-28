n, s = map(str, input().split())
n = int(n)
digit_info = [
    [1, 3, 0, 3, 1],
    [0, 2, 0, 2, 0],
    [1, 2, 1, 1, 1],
    [1, 2, 1, 2, 1],
    [0, 3, 1, 2, 0],
    [1, 1, 1, 2, 1],
    [1, 1, 1, 3, 1],
    [1, 2, 0, 2, 0],
    [1, 3, 1, 3, 1],
    [1, 3, 1, 2, 1],
]
digit = [[], [], [], [], []]

for i in range(5):
    if i == 0 or i == 2 or i == 4:
        for num in s:
            num = int(num)
            if digit_info[num][i]:
                s_digit = " " + "-" * n + " "
            else:
                s_digit = " " * (n + 2)
            digit[i].append(s_digit + " ")
    else:
        for num in s:
            num = int(num)
            if digit_info[num][i] == 0:
                s_digit = " " * (n + 2)
            elif digit_info[num][i] == 1:
                s_digit = "|" + " " * (n + 1)
            elif digit_info[num][i] == 2:
                s_digit = " " * (n + 1) + "|"
            else:
                s_digit = "|" + " " * n + "|"
            digit[i].append(s_digit + " ")

print("".join(digit[0]))
for _ in range(n):
    print("".join(digit[1]))
print("".join(digit[2]))
for _ in range(n):
    print("".join(digit[3]))
print("".join(digit[4]))
