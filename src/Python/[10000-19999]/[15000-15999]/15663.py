n, m = map(int, input().split())

arr = list(map(int, input().split()))
arr.sort()

visited = [False for _ in range(n)]
ansList = []


def dfs(queue, visited):
    if len(queue) == m:
        ans = ""
        for num in queue:
            ans += str(num)
            ans += " "
        if ans not in ansList:
            ansList.append(ans)
    else:
        for idx in range(n):
            if not visited[idx]:
                queue.append(arr[idx])
                visited[idx] = True
                dfs(queue, visited)
                queue.pop(-1)
                visited[idx] = False


for i in range(n):
    queue = [arr[i]]
    visited[i] = True
    dfs(queue, visited)
    visited[i] = False

print("\n".join(ansList))
