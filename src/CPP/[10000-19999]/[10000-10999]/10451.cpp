#include <iostream>
#include <cstring>
#include <queue>
#define MAX_N 1001
using namespace std;

int N;
int CC = 0;
bool Graph[MAX_N][MAX_N];
bool visited[MAX_N] = {false, };
queue<int> myqueue;

void bfs(int node){
	if(visited[node]) return;
	else{
		CC++;
		visited[node] = true;
		myqueue.push(node);
		
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
	int T;
	cin >> T;
	for(int z=0; z<T; z++){
		CC = 0;
		cin >> N;
		memset(Graph, false, sizeof(Graph));
		memset(visited, false, sizeof(visited));
		for(int i=1; i<=N; i++){
			int u;
			cin >> u;
			Graph[i][u] = Graph[u][i] = true;
		}
		for(int i=1; i<=N; i++){
			bfs(i);
		}
		cout << CC << '\n';
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}