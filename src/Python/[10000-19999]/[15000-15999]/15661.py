import sys
from itertools import combinations

input = sys.stdin.readline
sys.setrecursionlimit(10**9)
n = int(input())
s = [list(map(int, input().split())) for _ in range(n)]
player = range(n)

ans = 10**9


def getStatus(team, teamStat, playerNum):
    for player in team:
        teamStat += s[player][playerNum] + s[playerNum][player]
    return teamStat


def backTracking(teamA, AStat, teamB, BStat, playerNum):
    global ans
    if playerNum == n:
        if not teamA or not teamB:
            return
        ans = min(abs(AStat - BStat), ans)
        return
    else:
        backTracking(
            teamA + [playerNum],
            getStatus(teamA, AStat, playerNum),
            teamB,
            BStat,
            playerNum + 1,
        )
        backTracking(
            teamA,
            AStat,
            teamB + [playerNum],
            getStatus(teamB, BStat, playerNum),
            playerNum + 1,
        )


backTracking([], 0, [], 0, 0)
print(ans)
