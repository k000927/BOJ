#include <iostream>
#include <cmath>
using namespace std;

void solve(){
	string two, eight;
	int temp = 0;
	cin >> two;
	for(int i=0; two.size() > 0; i++){
		if(i%3 == 0 && i != 0) {
			eight += temp+48;
			temp = 0;
		}
		temp += pow(2, i%3) * (two[two.size()-1]-48);
		two.pop_back();
	}
	eight += temp+48;
	for(int i=eight.size()-1; i>=0; i--){
		cout << eight[i];
	}
	cout << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}