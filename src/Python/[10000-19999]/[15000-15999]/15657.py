n, m = map(int, input().split())

arr = list(map(int, input().split()))
arr.sort()


def dfs(idx, queue):
    if len(queue) == m:
        ans = ""
        for num in queue:
            ans += str(num)
            ans += " "
        print(ans)
    else:
        for i in range(idx, n):
            queue.append(arr[i])
            dfs(i, queue)
            queue.pop(-1)


for i in range(n):
    queue = [arr[i]]
    dfs(i, queue)
