n, t = map(int, input().split())
city = []
for _ in range(n):
    s, x, y = map(int, input().split())
    city.append((s, x, y))

num_of_city = len(city)

graph = [[10 ** 9 for _ in range(num_of_city)] for _ in range(num_of_city)]

for i in range(num_of_city):
    for j in range(i, num_of_city):
        if i == j:
            graph[i][j] = 0
            continue
        s1, x1, y1 = city[i]
        s2, x2, y2 = city[j]
        if s1 == 1 and s2 == 1:
            graph[i][j] = min(t, abs(x1 - x2) + abs(y1 - y2))
        else:
            graph[i][j] = abs(x1 - x2) + abs(y1 - y2)

for i in range(num_of_city):
    for j in range(i, num_of_city):
        for k in range(num_of_city):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

m = int(input())
for _ in range(m):
    a, b = map(int, input().split())
    if a > b:
        a, b = b, a
    print(graph[a - 1][b - 1])
