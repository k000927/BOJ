#include <iostream>
using namespace std;

void solve(){
	int n, num, cnt = 0;
	cin >> n;
	int* arr = new int[n];
	for(int i=0; i<n; i++){
		int temp;
		cin >> temp;
		arr[i] = temp;
	}
	cin >> num;
	for(int i=0; i<n; i++){
		if(arr[i] == num) cnt++;
	}
	cout << cnt << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}