from collections import deque

m, n = map(int, input().split())
castle = [list(map(int, input().split())) for _ in range(n)]
visited = [[0 for _ in range(m)] for _ in range(n)]

roomSpace = []

for i in range(n):
    for j in range(m):
        arr = [True, True, True, True]  # 남, 동, 북, 서
        if castle[i][j] >= 8:
            arr[0] = False
            castle[i][j] -= 8
        if castle[i][j] >= 4:
            arr[1] = False
            castle[i][j] -= 4
        if castle[i][j] >= 2:
            arr[2] = False
            castle[i][j] -= 2
        if castle[i][j] == 1:
            arr[3] = False
        castle[i][j] = arr

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

room = 0
maxRoom1 = -1
maxRoom2 = -1


def bfs(i, j):
    global room, maxRoom1, maxRoom2, roomSpace
    queue = deque()

    queue.append((i, j))
    visited[i][j] = room + 1

    room1 = 1
    while queue:
        a, b = queue.popleft()
        for k in range(4):
            x = a + dx[k]
            y = b + dy[k]
            if x < 0 or x >= n or y < 0 or y >= m:
                continue
            if visited[x][y]:
                continue
            if not castle[a][b][k]:
                continue
            elif castle[a][b][k]:
                room1 += 1
                visited[x][y] = room + 1
                queue.append((x, y))
    maxRoom1 = max(maxRoom1, room1)
    roomSpace.append(room1)
    room += 1


for i in range(n):
    for j in range(m):
        if not visited[i][j]:
            bfs(i, j)


def getMax2(i, j):
    return ""


for i in range(n):
    for j in range(m):
        for k in range(4):
            x = i + dx[k]
            y = j + dy[k]
            if x < 0 or x >= n or y < 0 or y >= m:
                continue
            if visited[i][j] == visited[x][y]:
                continue
            maxRoom2 = max(
                maxRoom2, roomSpace[visited[i][j] - 1] + roomSpace[visited[x][y] - 1]
            )

print(room)
print(maxRoom1)
print(maxRoom2)
