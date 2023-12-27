n, m = map(int, input().split())

arr = list(map(int, input().split()))
arr.sort()
ans = []


def dfs(queue):
    global arr
    if len(queue) == m:
        ans_str = ""
        for idx in queue:
            ans_str += str(arr[idx])
            ans_str += " "
        if ans_str not in ans:
            ans.append(ans_str)
    else:
        x = queue[-1]
        for i in range(x, n):
            queue.append(i)
            dfs(queue)
            queue.pop()


for i in range(n):
    dfs([i])

print("\n".join(ans))
