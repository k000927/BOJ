#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

const int MAX = 100001;
int solo;
bool visit[MAX];
int adj[MAX];

vector<int> possibility;
bool check[MAX];

void isteam(){
	int last = possibility.back();
	for(int i=0; possibility[i] != last; i++){
		solo++;
	}
}

void DFS(int cur){
	if(visit[cur]) return;
	else{
		visit[cur] = true;
		possibility.push_back(cur);
		int next = adj[cur];
		if(visit[next]) {
			possibility.push_back(next);
			return;
		}
		DFS(next);
	}
}

void solve(){
	int T;
	cin >> T;
	for(int z=0; z<T; z++){
		memset(visit, false, sizeof(visit));
		memset(check, true, sizeof(check));
		int n;
		solo = 0;
		cin >> n;
		for(int i=1; i<=n; i++){
			int v;
			cin >> v;
			adj[i] = v;
		}
		for(int i=1; i<=n; i++){
			DFS(i);
			if(possibility.size() != 0) isteam();
			possibility.clear();
		}
		cout << solo << '\n';
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}