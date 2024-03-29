n, m = map(int, input().split())
listA = [list(map(int, input().split())) for _ in range(n)]
listB = [list(map(int, input().split())) for _ in range(n)]
listC = []
for i in range(n):
    tempArr = []
    for j in range(m):
        tempArr.append(listA[i][j] + listB[i][j])
    listC.append(tempArr)

for line in listC:
    print(" ".join(map(str, line)))
