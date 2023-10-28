#include <iostream>
using namespace std;

void solve(){
	long long int n, m;
	cin >> n >> m;
	if(n == 2){
		if(m < 3) cout << "1\n";
		else if(m < 5) cout << "2\n";
		else if(m < 7) cout << "3\n";
		else cout << "4\n";
		return;
	}
	else if(n == 1){
		cout << "1\n";
	}
	else{
		if(m == 1) cout << "1\n";
		else if(m == 2) cout << "2\n";
		else if(m < 4) cout << "3\n";
		else if(m < 7) cout << "4\n";
		else{
			cout << m - 2 << '\n';
		}
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}