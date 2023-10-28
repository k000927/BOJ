#include <iostream>
using namespace std;

void solve(){
	int sum = 0;
	int N;
	cin >> N;
	sum += N/5;
	sum += N/25;
	sum += N/125;
	cout << sum << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}