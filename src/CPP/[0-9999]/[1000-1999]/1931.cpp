#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<pair<int, int>> v;

bool cmp(pair<int, int>a , pair<int, int> b)
{
	if (a.second == b.second)
		return a.first < b.first;
	return a.second < b.second;
}

void solve(){
	int cnt = 0;
	int n;
	cin >> n;
	for(int i=0; i<n; i++){
		int start, end;
		cin >> start >> end;
		v.push_back(make_pair(start, end));
	}
	sort(v.begin(), v.end(), cmp);
	int end = v[0].second;
	cnt++;
	for(int i=1; i<n; i++){
		if(end <= v[i].first) {
			cnt++;
			end = v[i].second;
		}
	}
	cout << cnt << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}