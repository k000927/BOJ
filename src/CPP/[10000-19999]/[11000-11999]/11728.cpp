#include <iostream>
#include <vector>
using namespace std;

int N, M;
int* A;
int* B;
vector<int> v;

void solve(){
	cin >> N >> M;
	A = new int[N];
	B = new int[M];
	for(int i=0; i<N; i++){
		cin >> A[i];
	}
	for(int i=0; i<M; i++){
		cin >> B[i];
	}
	int a_index = 0;
	int b_index = 0;
	int i=0;
	while(a_index != N && b_index != M){
		if(A[a_index] < B[b_index]){
			v.push_back(A[a_index++]);
		}
		else v.push_back(B[b_index++]);
	}
	if(a_index == N){
		for(int i = b_index; i<M; i++){
			v.push_back(B[i]);
		}
	}
	else{
		for(int i = a_index; i<N; i++){
			v.push_back(A[i]);
		}
	}
	for(int i=0; i<(N+M); i++){
		cout << v[i] << " ";
	}
	cout << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}