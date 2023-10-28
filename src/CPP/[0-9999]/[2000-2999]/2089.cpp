#include <iostream>
#include <cmath>
using namespace std;

void solve(){
	long long int n;
	cin >> n;
	string minustwo;
	if(n == 0){
		cout << "0\n";
		return;
	}
	while(n != 1){
		if(n<0 && (n*(-1))%2 == 1){
			minustwo.push_back('1');
			n = (n-1)/-2;
		}
		else{
			minustwo.push_back(n%-2+48);
			n /= -2;
		}
	}
	minustwo.push_back('1');
	for(int i=minustwo.size()-1; i>=0; i--){
		cout << minustwo[i];
	}
	cout << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}