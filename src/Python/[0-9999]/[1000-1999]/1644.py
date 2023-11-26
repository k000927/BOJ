n = int(input())
count = 0
a = [False, False] + [True] * (n - 1)
primes = []

for i in range(2, n + 1):
    if a[i]:
        primes.append(i)
        for j in range(2 * i, n + 1, i):
            a[j] = False


def getPrimeSum(start_idx):
    idx = start_idx
    sum = primes[idx]
    while True:
        if sum == n:
            return True
        elif sum > n or idx == len(primes) - 1:
            return False
        idx += 1
        sum += primes[idx]


idx = 0
while True:
    if idx == len(primes):
        break
    elif getPrimeSum(idx):
        count += 1
    idx += 1

print(count)
