from heapq import heappush, heappop
import sys

n = int(sys.stdin.readline().strip())
heap_p = []
heap_n = []
for _ in range(n):
    x = int(sys.stdin.readline().strip())
    if x == 0:
        if not heap_p and not heap_n:
            print(0)
        else:
            if not heap_p:
                print(-1 * heappop(heap_n))
            elif not heap_n:
                print(heappop(heap_p))
            else:
                if heap_n[0] <= heap_p[0]:
                    print(-1 * heappop(heap_n))
                else:
                    print(heappop(heap_p))
    else:
        if x < 0:
            heappush(heap_n, -1 * x)
        else:
            heappush(heap_p, x)
