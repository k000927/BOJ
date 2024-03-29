import sys
from collections import deque

# sys.stdin = open("input.txt", "r")

n, m = tuple(map(int, input().split()))

board = [
    list(map(int, input().split()))
    for _ in range(n)
]

pos = []

dys = [0, 1, 0, -1]
dxs = [1, 0, -1, 0]

group = []


def inRange(y, x):
    return 0 <= y < n and 0 <= x < m


def bfs(startY, startX):
    board[startY][startX] = 3
    cnt = 0

    q = deque([(startY, startX)])
    needs = set()
    while q:
        y, x = q.popleft()
        cnt += 1

        for dy, dx in zip(dys, dxs):
            ny = y + dy
            nx = x + dx

            if inRange(ny, nx):
                # 다음 칸이 비어있는 경우
                if (ny, nx) not in needs and board[ny][nx] == 0:
                    needs.add((ny, nx))

                if board[ny][nx] == 2:
                    board[ny][nx] = 3
                    q.append((ny, nx))
    # 현재 그룹을 잡아먹기 위해 필요한 칸이 2칸 이하인 경우
    if len(needs) <= 2:
        group.append((needs, cnt))


ans = 0
cur_group = []


# cnt: 현재 잡은 돌의 개수
# start: combination을 위한 개수
# edges: 놓은 돌의 위치들
# count: 현재 선택 위치
def combi(cnt, start, edges, count):
    global ans
    if len(edges) > 2:
        return

    ans = max(ans, cnt)

    if count == len(group):
        return

    for i in range(start, len(group)):
        cur_group.append(group[i])

        cur_set = set(edges)
        for e in group[i][0]:
            cur_set.add(e)

        combi(cnt + group[i][1], i + 1, cur_set, count + 1)

        cur_group.pop()


for i in range(n):
    for j in range(m):
        if board[i][j] == 2:
            bfs(i, j)

combi(0, 0, set(), 0)

print(ans)
