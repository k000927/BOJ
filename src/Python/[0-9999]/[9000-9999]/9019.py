from collections import deque

t = int(input())


for _ in range(t):
    a, b = map(int, input().split())
    visited = [False for _ in range(10000)]
    queue = deque()
    queue.append([a, ""])
    while queue:
        num, op = queue.popleft()
        if num == b:
            print(op)
            break
        d = num * 2 % 10000
        if not visited[d]:
            visited[d] = True
            queue.append([d, op + "D"])
        s = (num - 1) % 10000
        if not visited[s]:
            visited[s] = True
            queue.append([s, op + "S"])
        l = num // 1000 + (num % 1000) * 10
        if not visited[l]:
            visited[l] = True
            queue.append([l, op + "L"])
        r = num // 10 + (num % 10) * 1000
        if not visited[r]:
            visited[r] = True
            queue.append([r, op + "R"])
