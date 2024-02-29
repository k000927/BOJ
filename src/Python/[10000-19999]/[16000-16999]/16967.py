h, w, x, y = map(int, input().split())
arrB = [list(map(int, input().split())) for _ in range(h + x)]

for i in range(h):
    for j in range(w):
        arrB[i + x][j + y] -= arrB[i][j]

for i in range(h):
    print(" ".join(map(str, arrB[i][:w])))
