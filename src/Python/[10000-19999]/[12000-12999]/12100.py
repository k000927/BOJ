from collections import deque
from copy import deepcopy

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
zeroBoard = [[0 for _ in range(n)] for _ in range(n)]
queue = deque()

ans = 0


def getMax(board):
    m = 0
    for i in range(n):
        for j in range(n):
            m = max(m, board[i][j])
    return m


def moveLeft(board):
    tempBoard = deepcopy(zeroBoard)
    for i in range(n):
        stack = []
        for j in range(n):
            if board[i][j] == 0:
                continue
            else:
                if stack and stack[-1][0] == board[i][j] and stack[-1][1]:
                    stack[-1][0] *= 2
                    stack[-1][1] = False
                else:
                    stack.append([board[i][j], True])
        for k in range(len(stack)):
            tempBoard[i][k] = stack[k][0]
    return tempBoard


def moveRight(board):
    tempBoard = deepcopy(zeroBoard)
    for i in range(n):
        stack = []
        for j in range(n - 1, -1, -1):
            if board[i][j] == 0:
                continue
            else:
                if stack and stack[-1][0] == board[i][j] and stack[-1][1]:
                    stack[-1][0] *= 2
                    stack[-1][1] = False
                else:
                    stack.append([board[i][j], True])
        for k in range(len(stack)):
            tempBoard[i][n - k - 1] = stack[k][0]
    return tempBoard


def moveUp(board):
    tempBoard = deepcopy(zeroBoard)
    for j in range(n):
        stack = []
        for i in range(n):
            if board[i][j] == 0:
                continue
            else:
                if stack and stack[-1][0] == board[i][j] and stack[-1][1]:
                    stack[-1][0] *= 2
                    stack[-1][1] = False
                else:
                    stack.append([board[i][j], True])
        for k in range(len(stack)):
            tempBoard[k][j] = stack[k][0]
    return tempBoard


def moveDown(board):
    tempBoard = deepcopy(zeroBoard)
    for j in range(n):
        stack = []
        for i in range(n - 1, -1, -1):
            if board[i][j] == 0:
                continue
            else:
                if stack and stack[-1][0] == board[i][j] and stack[-1][1]:
                    stack[-1][0] *= 2
                    stack[-1][1] = False
                else:
                    stack.append([board[i][j], True])
        for k in range(len(stack)):
            tempBoard[n - k - 1][j] = stack[k][0]
    return tempBoard


queue.append((board, 0))

board = moveDown(board)

while queue:
    localBoard, cnt = queue.popleft()
    if cnt == 5:
        ans = max(ans, getMax(localBoard))
    else:
        queue.append((moveLeft(localBoard), cnt + 1))
        queue.append((moveRight(localBoard), cnt + 1))
        queue.append((moveDown(localBoard), cnt + 1))
        queue.append((moveUp(localBoard), cnt + 1))

print(ans)
