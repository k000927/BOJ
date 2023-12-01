import sys

n, m = map(int, input().split())

unheard = []
unseen = []
dbj = []

for i in range(n):
    unheard.append(sys.stdin.readline().strip())

for i in range(m):
    unseen.append(sys.stdin.readline().strip())

data = list(set(unheard + unseen))
data.sort()


def is_dbj(name):
    global data
    global dbj
    start = 0
    end = len(data) - 1
    while start <= end:
        mid = (start + end) // 2
        if data[mid] == name:
            del data[mid]
            return
        elif data[mid] > name:
            end = mid - 1
        else:
            start = mid + 1
    dbj.append(name)
    return


for i in range(n):
    is_dbj(unheard[i])

for j in range(m):
    is_dbj(unseen[j])

dbj.sort()
print(len(dbj))
print("\n".join(dbj))
