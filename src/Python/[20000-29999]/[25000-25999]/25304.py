x = int(input())
n = int(input())
won = 0

for _ in range(n):
    a, b = map(int, input().split())
    won += a * b

print("Yes" if won == x else "No")
