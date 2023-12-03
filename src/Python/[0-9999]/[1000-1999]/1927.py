import sys
from heapq import heappush, heappop

n = int(sys.stdin.readline().strip())
heap = []

for i in range(n):
    n = int(sys.stdin.readline().strip())
    if n == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heap[0])
            heappop(heap)
    else:
        heappush(heap, n)
