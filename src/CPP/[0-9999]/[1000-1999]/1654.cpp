#include <iostream>
#include <algorithm>
using namespace std;

long long int n, k;
long long int max_lan = -1; // 가장 긴 랜선의 길이를 저장하는 배열
long long int* lan; // 랜선의 길이를 저장하는 배열

bool ispossible(long long int x){ // xcm의 n개 랜선 만들 수 있는지
	long long int cnt = 0;
	for(long long int i=0; i<k; i++){
		cnt += lan[i]/x; 
		if(cnt >= n) return true;
	}
	return false;
}

long long int binary_search(long long int lo, long long int hi){
	long long int mid = (lo+hi)/2;
	if(lo == hi){
		if(!ispossible(lo)) return lo-1;
		else if(lo == max_lan) return lo;
		else return -1;
	}
	if(!ispossible(mid)) return binary_search(lo, mid);
	else return binary_search(mid+1, hi);
}

void solve(){
	cin >> k >> n;
	lan = new long long int[n];
	for(long long int i=0; i<k; i++){
		long long int temp;
		cin >> temp;
		lan[i] = temp;
		max_lan = max(temp, max_lan);
	}
	cout << binary_search(1, max_lan) << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}