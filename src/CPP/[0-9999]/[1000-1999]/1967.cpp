#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

int n;
const int MAX = 10001;
bool visit[MAX];
vector<pair<int, int>> adj[MAX];
int maxNode = 0;
int maxDist = 0;

void DFS(int node, int dist){
	if(visit[node]) return;
	if(maxDist < dist){
		maxNode = node;
		maxDist = dist;
	}
	visit[node] = true;
	for(int i=0; i<adj[node].size(); i++){
		int nextIndex = adj[node][i].first;
		int nextDist = adj[node][i].second;
		DFS(nextIndex, nextDist + dist);
	}
}

void solve(){
	cin >> n;
	for(int i=0; i<n-1; i++){
		int a, b, c; // a : 부모 노드, b : 자식 노드, c : 가중치
		cin >> a >> b >> c;
		adj[a].push_back({b, c});
		adj[b].push_back({a, c});
	}
	for(int i=1; i<=n; i++){
		sort(adj[i].begin(), adj[i].end());
	}
	DFS(1, 0);
	memset(visit, false, sizeof(visit));
	maxDist = 0;
	DFS(maxNode, 0);
	cout << maxDist << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}