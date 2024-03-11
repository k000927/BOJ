prime = [True for _ in range(10000)]
prime[0] = False
prime[1] = False

for i in range(2, 100):
    if prime[i]:
        j = 2
        while i * j < 10000:
            prime[i * j] = False
            j += 1

from collections import deque

t = int(input())

for _ in range(t):
    a, b = map(int, input().split())
    queue = deque()
    visited = [False for _ in range(10000)]
    queue.append((a, 0))
    visited[a] = True
    flag = True
    while queue:
        num, cnt = queue.popleft()
        if num == b:
            print(cnt)
            flag = False
            break
        for i in range(4):
            for j in range(10):
                nextNum = list(str(num))
                nextNum[i] = str(j)
                nextNum = int("".join(nextNum))
                if nextNum < 1000:
                    continue
                if not visited[nextNum] and prime[nextNum]:
                    visited[nextNum] = True
                    queue.append((nextNum, cnt + 1))

    if flag:
        print("Impossible")
