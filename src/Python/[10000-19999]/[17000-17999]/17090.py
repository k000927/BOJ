n, m = map(int, input().split())
maze = [list(input()) for _ in range(n)]
escape = [[0 for _ in range(m)] for _ in range(n)]  # 0: 탐색하지 않음. 1: 탈출 가능, 2: 탈출 불가능

ans = 0

for i in range(n):
    for j in range(m):
        stack = []
        stack.append((i, j))
        flag = False
        while True:
            x, y = stack[-1]
            if x < 0 or x >= n or y < 0 or y >= m:
                stack.pop()
                ans += 1
                flag = True
                break
            if escape[x][y] == 2:
                break
            if escape[x][y] == 1:
                ans += 1
                flag = True
                break
            escape[x][y] = 2
            if maze[x][y] == "U":
                stack.append((x - 1, y))
            elif maze[x][y] == "R":
                stack.append((x, y + 1))
            elif maze[x][y] == "D":
                stack.append((x + 1, y))
            elif maze[x][y] == "L":
                stack.append((x, y - 1))
        if flag:
            for s in stack:
                x, y = s
                escape[x][y] = 1

print(ans)
