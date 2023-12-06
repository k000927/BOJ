import sys
from heapq import heappop, heappush

n = int(input())
heap = []
for _ in range(n):
    x = int(sys.stdin.readline().strip())
    if x == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heappop(heap) * -1)
    else:
        heappush(heap, x * -1)
