import sys

input = sys.stdin.readline

n, b = map(int, input().split())

originalMatrix = []

for _ in range(n):
    originalMatrix.append(list(map(int, input().split())))


def matrixMul(mat1, mat2):
    ansMat = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                ansMat[i][j] = (
                    ansMat[i][j] % 1000 + (mat1[i][k] % 1000 * mat2[k][j] % 1000) % 1000
                ) % 1000
    return ansMat


def matrixPow(matrix, N):
    if N == 1:
        return matrix
    else:
        mat = matrixPow(matrix, N // 2)
        if N % 2 == 0:
            return matrixMul(mat, mat)
        else:
            return matrixMul(matrixMul(mat, mat), originalMatrix)


ansMat = matrixPow(originalMatrix, b)

for i in range(n):
    for j in range(n):
        ansMat[i][j] %= 1000

for idx in range(n):
    print(" ".join(map(str, ansMat[idx])))
