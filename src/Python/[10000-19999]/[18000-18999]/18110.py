def round(num):
    return int(num) + (1 if num - int(num) >= 0.5 else 0)


n = int(input())
if not n:
    print(0)
else:
    score = [int(input()) for _ in range(n)]
    trunc = round(n * 0.15)
    apply_truc = sorted(score)[trunc : n - trunc]
    average = round(sum(apply_truc) / len(apply_truc))
    print(average)
