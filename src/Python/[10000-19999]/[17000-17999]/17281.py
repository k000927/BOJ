from itertools import permutations
import sys

input = sys.stdin.readline
inning = int(input())
hits = [[]] + [[0] + list(map(int, input().split())) for _ in range(inning)]

hitters = list(permutations(range(2, 10), 8))

for i in range(len(hitters)):
    hitters[i] = list(hitters[i])[:3] + [1] + list(hitters[i])[3:]

ans = 0


def playGame(hitter):
    global ans
    curInning = 1
    curOut = 0
    p1, p2, p3 = 0, 0, 0
    score = 0
    hitterIdx = 0
    while curInning < inning + 1:
        curHitter = hitter[hitterIdx % 9]
        if hits[curInning][curHitter] == 0:
            curOut += 1
            if curOut == 3:
                curOut = 0
                p1 = p2 = p3 = 0
                curInning += 1
                hitterIdx += 1
                continue
        elif hits[curInning][curHitter] == 1:
            score += p3
            p1, p2, p3 = 1, p1, p2
        elif hits[curInning][curHitter] == 2:
            score += p3 + p2
            p1, p2, p3 = 0, 1, p1
        elif hits[curInning][curHitter] == 3:
            score += p1 + p2 + p3
            p1, p2, p3 = 0, 0, 1
        elif hits[curInning][curHitter] == 4:
            score += p1 + p2 + p3 + 1
            p1, p2, p3 = 0, 0, 0
        hitterIdx += 1
    ans = max(ans, score)


for hitter in hitters:
    playGame(hitter)

print(ans)
