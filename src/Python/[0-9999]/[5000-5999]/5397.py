import sys

input = sys.stdin.readline
t = int(input())
for i in range(t):
    tmp = input().rstrip()
    pwd = []  # 비밀번호 배열
    sub = []  # 커서 이동 시 담아놓을 배열
    for a in tmp:
        if a == "<":  # 왼쪽 커서일 때
            if pwd:  # pwd가 존재할 경우에만
                sub.append(pwd.pop())  # pop 후 sub 배열에 넣기
        elif a == ">":  # 오른쪽 커서일 때
            if sub:  # sub가 존재할 경우에만
                pwd.append(sub.pop())  # pop 후 pwd 배열에 넣기
        elif a == "-":  # - 일 때
            if pwd:  # pwd가 존재할 경우에만
                pwd.pop()  # pwd pop하여 삭제
        else:
            pwd.append(a)  # 위의 3가지 문자 외 어느 문자든 전부 pwd에 삽입
    print("".join(pwd), "".join(sub[::-1]), sep="")
