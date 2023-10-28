#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

bool Error[10];

bool ispossible(int x){
	do{
		if(Error[x%10]) return false;
		x/=10;
	}while(x);
	return true;
}

void solve(){
	int N, M, ans1, ans2;
	cin >> N >> M;
	ans1 = abs(N-100);
	for(int i=0; i<M; i++){
		int temp;
		cin >> temp;
		Error[temp] = true;
	}
	for(int i=0; ; i++){
		if(N-i >= 0 && ispossible(N-i)) {
			ans2 = to_string(N-i).size() + i;
			cout << min(ans1, ans2) << endl;
			return;
		}
		else if(ispossible(N+i)){
			ans2 = to_string(N+i).size() + i;
			cout << min(ans1, ans2) << endl;
			return;
		}
		if(i>=ans1) {
			cout << ans1 << endl;
			return;
		}
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}