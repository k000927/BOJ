string = input()

ans = ""

for s in string:
    if ord(s) <= 90:
        ans += chr(ord(s) + 32)
    else:
        ans += chr(ord(s) - 32)

print(ans)
