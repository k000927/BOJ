S = int(input())
ans = 1
while(1):
    if ans*(ans+1)/2 <= S:
        ans+=1
    else: break
print(ans-1)