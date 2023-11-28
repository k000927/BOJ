#include <iostream>
#include <cmath>
#include <vector>
using namespace std;
long long num [1000001];
void solve(){
    long long n, m;
    cin >> n >> m;
    for(long long i = n; i<= m; i++){
        num[i-n] = i;
    }
    for (long long i = 2; i*i <= m; i++){
        long long N = n /(i*i);
        if(n%(i*i) != 0) N++;
        while(N*i*i <= m){
            num[N*i*i-n] = 0;
            N++;
        }
    }
    int ans = 0;
	for (long long i = n; i <= m; i++) {
		if (num[i - n] != 0)
			ans++;
	}
	cout << ans << endl;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}