#include <iostream>
using namespace std;

int n, k;
int* coin;

void solve(){
	int min = 0;
	cin >> n >> k;
	coin = new int[n];
	for(int i=0; i<n; i++){
		cin >> coin[i];
	}
	for(int i=n-1; i>=0; i--){
		min += k/coin[i];
		k -= k/coin[i] * coin[i];
	}
	cout << min << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}