#include<iostream>
#include<string>
#define mod 1000000
using namespace std;

int main(){
    string s; cin>>s;
    int size = s.size();
    if(s[0]=='0'){
        cout<<0; return 0;
    }
    int dp[5001] = {1,1};
    for(int i=2; i<=size; i++){
        if(s[i-1]>'0') dp[i]=dp[i-1]%mod;
        
        int n =(s[i-2]-'0')*10 + s[i-1]-'0';
        if(10<=n && 26>=n){
            dp[i] = (dp[i]+dp[i-2])%mod;
        }
    }
    cout<<dp[size];
}