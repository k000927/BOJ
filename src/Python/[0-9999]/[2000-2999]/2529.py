k = int(input())
sign = list(map(str, input().split()))

maxAns = -1
minAns = 9999999999
num = [False for _ in range(10)]


def back_tracking(queue, num):
    global maxAns, minAns
    if len(queue) == k + 1:
        minAns = min(int("".join(map(str, queue))), minAns)
        maxAns = max(int("".join(map(str, queue))), maxAns)
        return
    else:
        for idx in range(len(num)):
            if not queue:
                num[idx] = True
                back_tracking(queue + [idx], num)
                num[idx] = False
            else:
                if num[idx]:
                    continue
                preNum = queue[-1]
                s = sign[len(queue) - 1]
                if s == "<":
                    if preNum < idx:
                        num[idx] = True
                        back_tracking(queue + [idx], num)
                        num[idx] = False
                else:
                    if preNum > idx:
                        num[idx] = True
                        back_tracking(queue + [idx], num)
                        num[idx] = False


back_tracking([], num)
if len(str(maxAns)) != k + 1:
    maxAns = "0" + str(maxAns)
if len(str(minAns)) != k + 1:
    minAns = "0" + str(minAns)
print(maxAns)
print(minAns)
