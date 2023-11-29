import sys

N, M, B = map(int, input().split())
arr = []
for i in range(N):
    arr += list(map(int, input().split()))
arr.sort()

possible_Block = sum(arr) + B
max_Floor = int(possible_Block / len(arr))
ans_time = sys.maxsize
ans_floor = -1


for target in range(max_Floor, -1, -1):
    time = 0
    left_block = possible_Block
    for idx in range(len(arr)):
        block_use = target - arr[idx]
        if block_use > 0:
            time += block_use
        else:
            time += -1 * block_use * 2
        left_block -= target
        if time > ans_time:
            break
    if left_block < 0:
        continue
    else:
        if ans_time > time:
            ans_time = time
            ans_floor = target

print(ans_time, ans_floor)
