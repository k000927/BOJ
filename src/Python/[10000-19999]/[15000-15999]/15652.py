n, m = map(int, input().split())


def dfs(queue):
    if len(queue) == m:
        string = ""
        for num in queue:
            string += str(num)
            string += " "
        print(string)
    else:
        x = queue[-1]
        for i in range(x, n + 1):
            queue.append(i)
            dfs(queue)
            queue.pop()


for i in range(1, n + 1):
    dfs([i])
