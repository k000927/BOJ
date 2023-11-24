import math

n = int(input())
ans = ""


def isGoodString(string):
    string
    for i in range(1, int(len(string) / 2) + 1):
        substr1 = string[-2 * i : -i]
        substr2 = string[-i:]
        if substr1 == substr2:
            return False
    return True


def back(ans):
    if not isGoodString(ans):
        return
    if len(ans) == n:
        print(ans)
        exit()
    else:
        back(ans + "1")
        back(ans + "2")
        back(ans + "3")
        return ()


back(ans)
