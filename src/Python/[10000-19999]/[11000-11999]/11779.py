import sys
import heapq

input = sys.stdin.readline
INF = float("inf")

n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    start, end, cost = map(int, input().split())
    graph[start].append((end, cost))

start_city, end_city = map(int, input().split())


# 다익스트라 알고리즘
# 반환 값은 3개
# 1. 최소 비용
# 2. 최단경로 역추적을 위한 linked list와 유사한 느낌의 리스트
# 3. 이동한 도시의 개수
def dijkstra(start_city, end_city):
    SSSP = [INF] * (n + 1)
    SSSP[start_city] = 0
    path = [0] * (n + 1)
    # path[idx]는 idx까지의 최단경로 상에서,
    # idx 방문 바로 이전의 노드를 의미
    path[start_city] = 0
    count = [0] * (n + 1)
    q = []
    heapq.heappush(q, (0, start_city))

    while q:
        cnt_cost, cnt_city = heapq.heappop(q)

        if cnt_cost > SSSP[cnt_city]:
            continue

        for adj_city, adj_cost in graph[cnt_city]:
            cal_cost = cnt_cost + adj_cost

            if cal_cost < SSSP[adj_city]:
                SSSP[adj_city] = cal_cost
                path[adj_city] = cnt_city
                count[adj_city] = count[cnt_city] + 1
                heapq.heappush(q, (cal_cost, adj_city))

    return (SSSP[end_city], path, count[end_city])


min_cost, linked, count = dijkstra(start_city, end_city)

# 최단경로 역추적
path = [end_city]
prev = end_city
for _ in range(count):
    path.append(linked[prev])
    prev = linked[prev]

print(min_cost, len(path), " ".join(map(str, path[::-1])), sep="\n")
