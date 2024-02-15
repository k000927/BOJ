import sys

arr = [0 for _ in range(20)]


def add(arr, x):
    arr[x - 1] = 1


def remove(arr, x):
    arr[x - 1] = 0


def check(arr, x):
    print(arr[x - 1])


def toggle(arr, x):
    if arr[x - 1]:
        arr[x - 1] = 0
    else:
        arr[x - 1] = 1


def all(arr):
    for i in range(20):
        arr[i] = 1


def empty(arr):
    for i in range(20):
        arr[i] = 0


M = int(input())
for i in range(M):
    ops = sys.stdin.readline().strip()
    if ops == "all":
        all(arr)
    elif ops == "empty":
        empty(arr)
    else:
        op, n = map(str, ops.split())
        if op == "add":
            add(arr, int(n))
        elif op == "remove":
            remove(arr, int(n))
        elif op == "check":
            check(arr, int(n))
        else:
            toggle(arr, int(n))
