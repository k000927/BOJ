#include <iostream>
using namespace std;

long long int fact(int N){
	if(N == 1) return 1;
	else{
		return N*fact(N-1);
	}
}

void solve(){
	int N;
	cin >> N;
	if(N == 0){
		cout << 1 << '\n';
		return;
	}
	cout << fact(N) << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}