def bin_search(arr, target, start, end):
    while start <= end:
        pivot = (start+end)//2
        if target == arr[pivot]:
            return True
        elif target < arr[pivot]:
            end = pivot - 1
        elif target >= arr[pivot]:
            start = pivot+1
    return False

N = int(input())
arrN = list(map(int, input().split()))
arrN.sort()
ans = []

M = int(input())
arrM = list(map(int, input().split()))

for i in range(0, M, 1):
    if bin_search(arrN, arrM[i], 0, N-1): ans.append("1")
    else: ans.append("0")

print(" ".join(ans))