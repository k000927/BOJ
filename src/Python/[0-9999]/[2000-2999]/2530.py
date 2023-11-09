A, B, C = map(int, input().split(' '))
D = int(input())
E = A*3600 + B*60 + C + D
H = int(E/3600)
E -= H*3600
M = int(E/60)
E -= M*60
print(H%24, M, E)