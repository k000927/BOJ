n = int(input())
arr = list(map(int, input().split()))
visited = [False for _ in range(n)]
ans = -100000000


def bruteForce(queue, visited, sum):
    global ans
    if len(queue) == n:
        ans = max(ans, sum)
        return
    else:
        for idx in range(len(arr)):
            if not queue:
                visited[idx] = True
                bruteForce([arr[idx]], visited, 0)
                visited[idx] = False
            else:
                if not visited[idx]:
                    visited[idx] = True
                    bruteForce(
                        queue + [arr[idx]], visited, sum + abs(queue[-1] - arr[idx])
                    )
                    visited[idx] = False


bruteForce([], visited, 0)
print(ans)
