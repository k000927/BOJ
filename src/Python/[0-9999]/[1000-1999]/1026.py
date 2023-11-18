S = int(input())
arrA = list(map(int, input().split()))
arrB = list(map(int, input().split()))

arrA.sort(reverse=True)
arrB.sort()
sum = 0

for i in range(0, S, 1):
    sum += arrA[i] * arrB[i]

print(sum)