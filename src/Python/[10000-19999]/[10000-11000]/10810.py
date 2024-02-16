n, m = map(int, input().split())

basket = [0 for _ in range(n + 1)]

for _ in range(m):
    i, j, k = map(int, input().split())
    for b in range(i, j + 1):
        if basket[b] != k:
            basket[b] = k

print(" ".join(map(str, basket[1:])))
