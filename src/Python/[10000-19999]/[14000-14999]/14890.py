n, l = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
ans = 0


def crossAble(line):
    flag = False
    cnt = 0
    preLevel = line[0]
    for level in line:
        if level == preLevel:
            cnt += 1
            if flag and cnt == l:
                flag = False
                cnt = 0
        elif level < preLevel:  # 내려갔을 때
            if flag and cnt < l:
                return False
            flag = True
            cnt = 1
            if preLevel - level != 1:
                return False
            if cnt == l:
                cnt = 0
                flag = False
        else:  # 올라갈 때
            if flag and cnt < l:
                return False
            flag = True
            if level - preLevel != 1:
                return False
            if cnt < l:
                return False
        if flag and cnt >= l:
            cnt = 1
            flag = False
        preLevel = level
    if flag:
        return False
    else:
        return True


for line in graph:
    if crossAble(line):
        ans += 1

for i in range(n):
    line = []
    for x in range(n):
        line.append(graph[x][i])
    if crossAble(line):
        ans += 1

print(ans)
