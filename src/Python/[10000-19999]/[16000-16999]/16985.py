from copy import deepcopy
from collections import deque
from itertools import permutations

maze = []
for _ in range(5):
    temp = []
    for z in range(5):
        temp.append(list(map(int, input().split())))
    maze.append(temp)

maze1 = set()


def spin(maze):
    tempMaze = deepcopy(maze)
    for i in range(5):
        temp = []
        for j in range(4, -1, -1):
            temp.append(tempMaze[j][i])
        maze[i] = temp


dx = [1, 0, -1, 0, 0, 0]
dy = [0, 1, 0, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

ans = 125


def bfs(maze):
    global ans
    queue = deque()
    if maze[0][0][0] == 0 or maze[4][4][4] == 0:
        return
    visited = [[[False for _ in range(5)] for _ in range(5)] for _ in range(5)]
    queue.append((0, 0, 0, 0))
    visited[0][0][0] = True
    while queue:
        a, b, c, cnt = queue.popleft()  # a: 깊이, b: 세로 c: 가로
        if a == 4 and b == 4 and c == 4:
            ans = min(ans, cnt)
            break
        for i in range(6):
            x = a + dx[i]
            y = b + dy[i]
            z = c + dz[i]
            if x < 0 or y < 0 or z < 0:
                continue
            if x > 4 or y > 4 or z > 4:
                continue
            if maze[x][y][z] == 0:
                continue
            if visited[x][y][z]:
                continue
            queue.append((x, y, z, cnt + 1))
            visited[x][y][z] = True


perm = list(permutations(range(5), 5))

for p in perm:
    for a in range(4):
        spin(maze[p[0]])
        bfs([maze[p[0]], maze[p[1]], maze[p[2]], maze[p[3]], maze[p[4]]])
        for b in range(4):
            spin(maze[p[1]])
            bfs([maze[p[0]], maze[p[1]], maze[p[2]], maze[p[3]], maze[p[4]]])
            for c in range(4):
                spin(maze[p[2]])
                bfs([maze[p[0]], maze[p[1]], maze[p[2]], maze[p[3]], maze[p[4]]])
                for d in range(4):
                    spin(maze[p[3]])
                    bfs([maze[p[0]], maze[p[1]], maze[p[2]], maze[p[3]], maze[p[4]]])
                    for e in range(4):
                        spin(maze[p[4]])
                        bfs([maze[p[0]], maze[p[1]], maze[p[2]], maze[p[3]], maze[p[4]]])

print(ans if ans < 125 else -1)
