student = [False for _ in range(31)]
for _ in range(28):
    student[int(input())] = True
for idx in range(1, 31):
    if not student[idx]:
        print(idx)
