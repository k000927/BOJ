#include <iostream>
using namespace std;

char base(int n){
	if(n<10) return (char)(n+48);
	else return (char)(n+55);
}

void solve(){
	int N, B;
	string num;
	cin >> N >> B;
	while(N!=0){
		num += base(N%B);
		N/=B;
	}
	for(int i=num.size()-1; i>=0; i--){
		cout << num[i];
	}
	cout << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}