n = int(input())
arr = list(map(int, input().split()))
ans = []
sort_arr = list(set(arr))
sort_arr.sort()
leng = len(sort_arr)


def bin_search(target, start, end):
    global sort_arr
    while True:
        mid = (start + end) // 2
        if sort_arr[mid] == target:
            return str(mid)
        elif sort_arr[mid] < target:
            start = mid + 1
        else:
            end = mid - 1


for i in range(n):
    ans.append(bin_search(arr[i], 0, leng))

print(" ".join(ans))
