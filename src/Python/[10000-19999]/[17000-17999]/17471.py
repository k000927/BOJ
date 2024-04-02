from collections import deque
from itertools import combinations

n = int(input())
popul = [0] + list(map(int, input().split()))

graph = [[] for _ in range(n + 1)]

for a in range(n):
    arr = list(map(int, input().split()))
    for b in arr[1:]:
        graph[a + 1].append(b)

ans = 10 ** 9

group = [0 for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]
group_idx = 1


def judge(A, B):
    global ans
    if not A or not B:
        return

    sumA = popul[A[0]]
    sumB = popul[B[0]]
    visited = [False for _ in range(n + 1)]

    tempA = deque()
    tempA.append(A[0])
    visited[A[0]] = True
    idxA = 1
    while tempA:
        curNode = tempA.popleft()
        for nextNode in graph[curNode]:
            if nextNode not in A:
                continue
            if visited[nextNode]:
                continue
            visited[nextNode] = True
            idxA += 1
            sumA += popul[nextNode]
            tempA.append(nextNode)
    if idxA != len(A):
        return

    tempB = deque()
    tempB.append(B[0])
    visited[B[0]] = True
    idxB = 1
    while tempB:
        curNode = tempB.popleft()
        for nextNode in graph[curNode]:
            if nextNode not in B:
                continue
            if visited[nextNode]:
                continue
            visited[nextNode] = True
            idxB += 1
            sumB += popul[nextNode]
            tempB.append(nextNode)
    if idxB != len(B):
        return
    ans = min(ans, abs(sumA - sumB))


def back_tracking(idx, A, B):
    if idx == n + 1:
        judge(A, B)
        return
    else:
        back_tracking(idx + 1, A + [idx], B)
        back_tracking(idx + 1, A, B + [idx])


back_tracking(1, [], [])
print(ans if ans != 10 ** 9 else -1)
