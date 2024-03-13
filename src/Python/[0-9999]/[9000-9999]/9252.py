import sys

read = sys.stdin.readline

word1, word2 = read().strip(), read().strip()
h, w = len(word1), len(word2)
cache = [[""] * (w + 1) for _ in range(h + 1)]

for i in range(1, h + 1):
    for j in range(1, w + 1):
        if word1[i - 1] == word2[j - 1]:
            cache[i][j] = cache[i - 1][j - 1] + word1[i - 1]
        else:
            if len(cache[i][j - 1]) > len(cache[i - 1][j]):
                cache[i][j] = cache[i][j - 1]
            else:
                cache[i][j] = cache[i - 1][j]
                
print(len(cache[-1][-1]))
print(cache[-1][-1])
