n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()


def dfs(queue):
    if len(queue) == m:
        for n in queue:
            print(n, end=" ")
        print()
        return
    else:
        for n in arr:
            queue.append(n)
            dfs(queue)
            queue.pop()


dfs([])
