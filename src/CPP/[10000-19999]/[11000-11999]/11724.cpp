#include <iostream>
#include <cstring>
#include <queue>
#define MAX_N 1001
using namespace std;

int N, M;
int CC = 0;
bool Graph[MAX_N][MAX_N];
bool visited[MAX_N] = {false, };
queue<int> myqueue;

void bfs(int node){
	if(visited[node]) return;
	else{
		visited[node] = true;
		myqueue.push(node);
	
		CC++;
		while(!myqueue.empty()){
			int curr = myqueue.front();
			myqueue.pop();	
			for(int i=1; i<=N; i++){
				if(!visited[i] && Graph[curr][i]){
					visited[i] = true;
					myqueue.push(i);
				}
			}
		}
	}
}

void solve(){
	cin >> N >> M;
	memset(Graph, false, sizeof(Graph));
	for(int i=0; i<M; i++){
		int u, v;
		cin >> u >> v;
		Graph[u][v] = Graph[v][u] = true;
	}
	for(int i=1; i<=N; i++){
		bfs(i);
	}
	cout << CC << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}