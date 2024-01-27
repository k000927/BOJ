import sys

input = sys.stdin.readline

n = int(input())


def isStrfry(a, b):
    alphaA = [0 for _ in range(26)]
    alphaB = [0 for _ in range(26)]
    for c in a:
        alphaA[ord(c) - 97] += 1
    for c in b:
        alphaB[ord(c) - 97] += 1
    for i in range(26):
        if alphaA[i] != alphaB[i]:
            print("Impossible")
            return
    print("Possible")


for _ in range(n):
    a, b = input().split()
    isStrfry(a, b)
