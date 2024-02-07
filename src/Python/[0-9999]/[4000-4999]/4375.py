def getNum(n):
    one = "1"
    while True:
        if int(one) % n == 0:
            return len(one)
        else:
            one += "1"


while True:
    try:
        print(getNum(int(input())))
    except:
        break
