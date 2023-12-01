import sys

n, m = map(int, input().split())
password = []
web = []
for i in range(n):
    password.append(sys.stdin.readline().strip().split())
for i in range(m):
    web.append(sys.stdin.readline().strip())

password.sort()


def find_pw(web):
    global password
    start = 0
    end = len(password) - 1
    while start <= end:
        mid = (start + end) // 2
        if password[mid][0] == web:
            print(password[mid][1])
            return
        elif password[mid][0] > web:
            end = mid - 1
        else:
            start = mid + 1


for i in range(m):
    find_pw(web[i])
