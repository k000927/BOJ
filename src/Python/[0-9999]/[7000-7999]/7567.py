str = input()
bowl = []
ans = 0

for i in range(0, len(str), 1):
    if str[i] == '(' :
        bowl.append(True)
    else: bowl.append(False)

for i in range(0, len(str), 1):
    if i == 0:
        ans += 10
    elif bowl[i] != bowl[i-1]:
        ans += 10
    else: ans += 5

print(ans)