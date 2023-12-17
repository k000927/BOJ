v = int(input())
A, B = 0, 0
str = input()
for idx in range(len(str)):
    if str[idx] == "A":
        A += 1
    else:
        B += 1

if A > B:
    print("A")
elif B > A:
    print("B")
else:
    print("Tie")
