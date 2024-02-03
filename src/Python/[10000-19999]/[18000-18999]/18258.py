import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
queue = deque()

for _ in range(n):
    ops = list(input().split())
    if ops[0] == "push":
        queue.append(int(ops[1]))
    elif ops[0] == "pop":
        if len(queue) == 0:
            print(-1)
        else:
            print(queue.popleft())
    elif ops[0] == "size":
        print(len(queue))
    elif ops[0] == "empty":
        if len(queue) == 0:
            print(1)
        else:
            print(0)
    elif ops[0] == "front":
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[0])
    else:
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[-1])
