#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;
vector<int> mylist;

int binary_search(int lo, int hi, int target){
	int mid = (hi+lo)/2;
	if(mylist[lo] == 10 && mylist[hi] == 0) return -1;
	if(lo == hi){
		if(mylist[hi] == target) return 1;
		else return 0;
	}
	if(mylist[mid] >= target) return binary_search(lo, mid, target);
	else return binary_search(mid+1, hi, target);
}

void solve(){
	cin >> n;
	for(int i=0; i<n; i++){
		int temp;
		cin >> temp;
		mylist.push_back(temp);
	}
	sort(mylist.begin(), mylist.end());
	cin >> m;
	for(int i=0; i<m; i++){
		int temp;
		cin >> temp;
		cout << binary_search(0, mylist.size(), temp) << " ";
	}
	cout << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}