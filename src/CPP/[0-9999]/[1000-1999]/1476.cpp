#include <iostream>
using namespace std;

void solve(){
	int e, s, m;
	cin >> e >> s >> m;
	for(int i=0; ;i++){
		if(i%15 == e-1 && i%28 == s-1 && i%19 == m-1){
			cout << i+1 << endl;
			return;
		}
	}
}

int main(){
	solve();
}