from heapq import heappop, heappush
import sys

T = int(sys.stdin.readline().strip())

for _ in range(T):
    queue_p = []
    queue_m = []
    num_vali = {}
    idx = 0
    k = int(sys.stdin.readline().strip())
    for x in range(k):
        op, n = map(str, sys.stdin.readline().strip().split())
        if op == "I":
            heappush(queue_p, int(n))
            heappush(queue_m, -1 * int(n))
            idx += 1
            if n in num_vali:
                num_vali[n] += 1
            else:
                num_vali[n] = 1
        else:
            if idx == 0:
                continue
            else:
                idx -= 1
                num = -1
                if n == "1":
                    while True:
                        num = -1 * heappop(queue_m)
                        if num_vali[str(num)] != 0:
                            break
                else:
                    while True:
                        num = heappop(queue_p)
                        if num_vali[str(num)] != 0:
                            break
                num_vali[str(num)] -= 1
    if idx == 0:
        print("EMPTY")
    else:
        while True:
            min = heappop(queue_m)
            if num_vali[str(-1 * min)] != 0:
                break
        while True:
            max = heappop(queue_p)
            if num_vali[str(max)] != 0:
                break
        print(-1 * min, max)
