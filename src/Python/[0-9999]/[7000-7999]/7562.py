from collections import deque

t = int(input())

dx = [-2, -2, -1, -1, 1, 1, 2, 2]
dy = [-1, 1, -2, 2, -2, 2, 1, -1]


def bfs(l, a, b, x, y, visitedChess):
    queue = deque()
    queue.append((a, b, 0))
    visitedChess[a][b] = True
    while queue:
        i, j, k = queue.popleft()
        if i == x and j == y:
            print(k)
            return
        else:
            for n in range(8):
                next_x = i + dx[n]
                next_y = j + dy[n]
                if (
                    next_x < 0
                    or next_x >= l
                    or next_y < 0
                    or next_y >= l
                    or visitedChess[next_x][next_y]
                ):
                    continue
                queue.append((next_x, next_y, k + 1))
                visitedChess[next_x][next_y] = True


for _ in range(t):
    l = int(input())
    visitedChess = [[False for _ in range(l)] for _ in range(l)]
    a, b = map(int, input().split())
    x, y = map(int, input().split())
    bfs(l, a, b, x, y, visitedChess)
