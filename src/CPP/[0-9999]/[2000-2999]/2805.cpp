#include <iostream>
#include <algorithm>
using namespace std;

long long int N, M, tallest = -1;
long long int* tree;

bool cut(int x){
	long long int length = 0;
	for(long long int i=0; i<N; i++){
		if(tree[i] > x) length += (tree[i] - x);
		else continue;
		if(length >= M) return true;
	}
	return false;
}

long long int binary_search(long long int lo, long long int hi){
	long long int mid = (lo+hi)/2;
	if(lo == hi){
		if(!cut(lo)) return lo-1;
		else return -1;
	}
	if(cut(mid)) return binary_search(mid+1, hi);
	else return binary_search(lo, mid);
}

void solve(){
	cin >> N >> M;
	tree = new long long int[N];
	for(long long int i=0; i<N; i++){
		long long int temp;
		cin >> temp;
		tree[i] = temp;
		tallest = max(tallest, temp);
	}
	cout << binary_search(0, tallest) << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}