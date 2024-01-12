import sys

sys.setrecursionlimit(10**9)
arr = []

while True:
    try:
        arr.append(int(input()))
    except:
        break


def postOrder(root, end):
    if root > end:
        return

    global arr

    right_start = end + 1
    for i in range(root + 1, end + 1):
        if arr[root] < arr[i]:
            right_start = i
            break

    postOrder(root + 1, right_start - 1)

    postOrder(right_start, end)
    print(arr[root])


postOrder(0, len(arr) - 1)
