import sys

n, k = map(int, input().split())
words = [set(sys.stdin.readline()) for _ in range(n)]
alpha = [False for _ in range(26)]
if k < 5:
    print(0)
    exit()
elif k == 26:
    print(n)
    exit()


def readable(word, alpha):
    word = word[4:-4]
    for w in range(len(word)):
        if not alpha[ord(word[w]) - 97]:
            return False
    return True


alpha[ord("a") - 97] = True
alpha[ord("n") - 97] = True
alpha[ord("t") - 97] = True
alpha[ord("i") - 97] = True
alpha[ord("c") - 97] = True

ans = -1


def dfs(localK, alpha):
    global ans
    if localK == k:
        cnt = 0
        for word in words:
            if readable(word, alpha):
                cnt += 1
        ans = max(cnt, ans)
    else:
        for i in range(26):
            if alpha[i]:
                continue
            alpha[i] = True
            dfs(localK + 1, alpha)
            alpha[i] = False


dfs(5, alpha)

print(ans)
