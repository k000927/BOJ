import sys

N = int(sys.stdin.readline())
words = list(sys.stdin.readline().rstrip())
mv = float('-inf')


def dfs(i, value):
    global mv
    if N == i:
        mv = max(mv, int(value))
        return
    if i + 4 <= N:
        dfs(i + 4, str(eval(''.join([value, words[i]] + [str(eval(''.join(words[i + 1:i + 4])))]))))
    if i + 2 <= N:
        dfs(i + 2, str(eval(''.join([value] + words[i:i + 2]))))


dfs(1, words[0])
print(mv)
