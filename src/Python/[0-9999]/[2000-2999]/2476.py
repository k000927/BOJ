N = int(input())
m = -1

def getScore(A, B, C):
    if A == B & B == C: return 10000 + A*1000
    elif A == B or A == C: return 1000 + A*100
    elif B == C: return 1000 + B*100
    else: return max(A, B, C)*100

for i in range(0, N, 1):
    A, B, C = map(int, input().split())
    m = max(m, getScore(A,B,C))

print(m)