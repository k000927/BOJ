n = int(input())
num = [False for _ in range(n + 1)]


def bruteForce(queue, num):
    if len(queue) == n:
        print(" ".join(queue))
    else:
        for idx in range(1, n + 1):
            if not num[idx]:
                num[idx] = True
                bruteForce(queue + [str(idx)], num)
                num[idx] = False


bruteForce([], num)
