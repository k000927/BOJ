#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> v;
vector<int> v2;

void solve(){
	int n;
	cin >> n;
	for(int i=0; i<n; i++){
		int temp;
		cin >> temp;
		v.push_back(temp);
	}
	stable_sort(v.begin(), v.end());
	int temp = 0;
	int ans = 0;
	for(int i=0; i<n; i++){
		temp += v[i];
		v2.push_back(temp);
		ans += v2[i];
	}
	cout << ans << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}