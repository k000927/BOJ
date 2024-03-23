from itertools import combinations
from copy import deepcopy
from collections import deque

n, m, d = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(n)]

archers = list(combinations(range(m), 3))

dx = [0, -1, 0]
dy = [-1, 0, 1]


def attack(board, archers, ans):
    monsters = set()
    for archer in archers:
        visited = [[False for _ in range(m)] for _ in range(n)]
        x = n - 1
        y = archer
        queue = deque()
        queue.append((x, y, 1))
        visited[x][y] = True
        while queue:
            x, y, cnt = queue.popleft()
            if cnt > d:
                continue
            if board[x][y] == 1:
                monsters.add((x, y))
                break
            for k in range(3):
                i = x + dx[k]
                j = y + dy[k]
                if i < 0 or i >= n or j < 0 or j >= m:
                    continue
                if visited[i][j]:
                    continue
                queue.append((i, j, cnt + 1))
    for monster in monsters:
        x, y = monster
        board[x][y] = 0
    ans[0] += len(monsters)


ans = -1
for archer in archers:
    localAns = [0]
    tempBoard = deepcopy(board)
    while True:
        flag = False
        attack(tempBoard, archer, localAns)
        for line in tempBoard:
            if 1 in line:
                flag = True
                break
        if flag:
            tempBoard = [[0 for _ in range(m)]] + tempBoard[:n - 1]
            continue
        break
    ans = max(ans, localAns[0])

print(ans)
