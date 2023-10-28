#include <iostream>
#include <cstring>
#include <stack>
#include <queue>
#define MAX_N 1001
using namespace std;

int N, M, V;
bool Graph[MAX_N][MAX_N];

void dfs(int node){
	bool visited[MAX_N] = {false, };
	stack<int> mystack;
	
	mystack.push(node);
	
	while(!mystack.empty()){
		int curr = mystack.top();
		mystack.pop();
		
		if(visited[curr]) continue;
		
		visited[curr] = true;
		cout << curr << ' ';
		
		for(int i=N; i>0; i--){
			if(!visited[i] && Graph[curr][i])
				mystack.push(i);
		}
	}
	cout << '\n';
}

void bfs(int node){
	bool visited[MAX_N] = {false, };
	queue<int> myqueue;
	visited[node] = true;
	myqueue.push(node);
	
	while(!myqueue.empty()){
		int curr = myqueue.front();
		myqueue.pop();
		
		cout << curr << ' ';
		
		for(int i=1; i<=N; i++){
			if(!visited[i] && Graph[curr][i]){
				visited[i] = true;
				myqueue.push(i);
			}
		}
	}
	cout << '\n';
}

void solve(){
	cin >> N >> M >> V;
	memset(Graph, false, sizeof(Graph));
	for(int i=0; i<M; i++){
		int u, v;
		cin >> u >> v;
		Graph[u][v] = Graph[v][u] = true;
	}
	dfs(V);
	bfs(V);
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}



/*

***** DFS *****

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int MAX = 1001;
bool visit[MAX];
vector<int> adj[MAX];

void DFS(int cur){
	visit[cur] = true;
	for(int i=0; i<adj[cur].size(); i++){
		int next = adj[cur][i];
		if(visit[next]) continue;
		DFS(next);
	}
}

void solve(){
	int n, m, v;
	cin >> n >> m >> v;
	
	for(int i=0; i<m; i++){
		int s, e;
		cin >> s >> e;
		adj[s].push_back(e);
		adj[e].push_back(s);
	}
	for(int i=1; i<=n; i++){
		sort(adj[i].begin(), adj[i].end());
	}
	DFS(v);
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}

*/



/*

***** BFS *****

#include <iostream>
#include <queue>

const int MAX = 1001;
bool visit[MAX];
vector<int> adj[MAX];
queue<int> Q;

void BFS(int v){
	Q.push(v);
	visit[v] = true;
	while(!Q.empty()){
		int cur = Q.front();
		Q.pop();
		for(int i=0; i<adj[cur].size(); i++){
			int next = adj[cur][i];
			if(!visit[next]){
				visit[next] = true;
				Q.push(next);
			}
		}
	}
}

void solve(){
	int n, m, v;
	cin >> n >> m >> v;
	
	for(int i=0; i<m; i++){
		int s, e;
		cin >> s >> e;
		adj[s].push_back(e);
		adj[e].push_back(s);
	}
	for(int i=1; i<=n; i++){
		sort(adj[i].begin(), adj[i].end());
	}
	BFS(v);
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}

*/