import sys
from collections import deque


def bfs(v):
    q = deque([v])
    while q:
        v = q.popleft()
        if v == k:
            print(array[v][0])
            print(array[v][1])
            return
        for next_v in (v - 1, v + 1, 2 * v):
            if 0 <= next_v < MAX:  # and not array[next_v]:
                if array[v][0] + 1 > array[next_v][0]:
                    continue
                elif array[v][0] + 1 == array[next_v][0]:
                    array[next_v][0] = array[v][0] + 1
                    array[next_v][1] += 1
                    q.append(next_v)
                else:
                    array[next_v][0] = array[v][0] + 1
                    array[next_v][1] = 1
                    q.append(next_v)


MAX = 100001
n, k = map(int, sys.stdin.readline().split())
array = [[MAX, 0] for _ in range(MAX)]  # 첫번째: 몇 초가 걸렸는지, 두번째: 경우의 수
array[n] = [0, 1]
bfs(n)
