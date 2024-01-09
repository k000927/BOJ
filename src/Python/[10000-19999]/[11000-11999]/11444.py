n = int(input())

m = 1000000007

Mat = [[1, 1], [1, 0]]


def fpow(M, n):
    if n == 1:
        return M
    else:
        x = fpow(M, n // 2)
        if n % 2 == 0:
            num1 = ((x[0][0] % m * x[0][0] % m) % m + (x[0][1] % m * x[1][0] % m)) % m
            num2 = ((x[0][0] % m * x[0][1] % m) % m + (x[0][1] % m * x[1][1] % m)) % m
            num3 = ((x[1][0] % m * x[0][0] % m) % m + (x[1][1] % m * x[1][0] % m)) % m
            num4 = ((x[1][0] % m * x[0][1] % m) % m + (x[1][1] % m * x[1][1] % m)) % m
            return [[num1, num2], [num3, num4]]
        else:
            num1 = ((x[0][0] % m * x[0][0] % m) % m + (x[0][1] % m * x[1][0] % m)) % m
            num2 = ((x[0][0] % m * x[0][1] % m) % m + (x[0][1] % m * x[1][1] % m)) % m
            num3 = ((x[1][0] % m * x[0][0] % m) % m + (x[1][1] % m * x[1][0] % m)) % m
            num4 = ((x[1][0] % m * x[0][1] % m) % m + (x[1][1] % m * x[1][1] % m)) % m
            y = [[num1, num2], [num3, num4]]
            num1 = ((y[0][0] % m * M[0][0] % m) % m + (y[0][1] % m * M[1][0] % m)) % m
            num2 = ((y[0][0] % m * M[0][1] % m) % m + (y[0][1] % m * M[1][1] % m)) % m
            num3 = ((y[1][0] % m * M[0][0] % m) % m + (y[1][1] % m * M[1][0] % m)) % m
            num4 = ((y[1][0] % m * M[0][1] % m) % m + (y[1][1] % m * M[1][1] % m)) % m
            return [[num1, num2], [num3, num4]]


print(fpow(Mat, n)[1][0])
