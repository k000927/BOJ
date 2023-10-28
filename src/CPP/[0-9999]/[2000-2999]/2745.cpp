#include <iostream>
#include <cmath>
using namespace std;

int change(char c){
	if(c>=48 && c<=57) return c-48;
	else return c-55;
}

void solve(){
	int B;
	string N;
	long long int num = 0;
	cin >> N >> B;
	for(int i=N.size()-1; i>=0; i--){
		num += pow(B, i) * change(N[N.size()-1 - i]);
	}
	cout << num << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}