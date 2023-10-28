#include <iostream>
#include <cstring>
#include <stack>
#include <queue>
#define MAX_N 26
using namespace std;

int N;
int Graph[MAX_N][2];

void preorder(int x){
	if(x == -1) return;
	cout << (char)(x+'A');
	preorder(Graph[x][0]);
	preorder(Graph[x][1]);
}

void inorder(int x){
	if(x == -1) return;
	inorder(Graph[x][0]);
	cout << (char)(x+'A');
	inorder(Graph[x][1]);
}

void postorder(int x){
	if(x == -1) return;
	postorder(Graph[x][0]);
	postorder(Graph[x][1]);
	cout << (char)(x+'A');
}

void solve(){
	cin >> N;
	memset(Graph, false, sizeof(Graph));
	for(int i=0; i<N; i++){
		char X, Y, Z;
		cin >> X >> Y >> Z;
		if(Y == 46) Graph[X-65][0] = -1;
		else Graph[X-65][0] = Y-65;
		if(Z == 46) Graph[X-65][1] = -1;
		else Graph[X-65][1] = Z-65;
	}
	preorder(0);
	cout << '\n';
	inorder(0);
	cout << '\n';
	postorder(0);
	cout << '\n';
}

int main(){
	//ios_base::sync_with_stdio(false);
	//cin.tie(nullptr);
	//cout.tie(nullptr);
	solve();
}