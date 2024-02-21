n = int(input())
lion = [[0, 0, 0] for _ in range(n)]
lion[0] = [1, 1, 1]
for i in range(1, n):
    lion[i][0] = lion[i - 1][1] % 9901 + lion[i - 1][2] % 9901
    lion[i][1] = lion[i - 1][0] % 9901 + lion[i - 1][2] % 9901
    lion[i][2] = lion[i - 1][0] % 9901 + lion[i - 1][1] % 9901 + lion[i - 1][2] % 9901

print(sum(lion[n - 1]) % 9901)
