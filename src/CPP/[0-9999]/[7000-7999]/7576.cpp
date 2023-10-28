#include <iostream>
#include <cstring>
#include <stack>
#include <queue>
#define MAX 1000
using namespace std;

int N, M;
int Graph[MAX][MAX] = {false, };
bool visited[MAX][MAX] = {false, };
int day = 0;
int D[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};

struct Point{
	int x, y;
};

queue<Point> myqueue_1;
queue<Point> myqueue_2;

bool isriped(){
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
			if(Graph[i][j] == 0) return false;
		}
	}
	return true;
}

void bfs(){
	if(day % 2 == 0){
		day++;
		while(!myqueue_1.empty()){
			Point curr = myqueue_1.front();
			myqueue_1.pop();

			for(int i=0; i<4; i++){
				int rx = curr.x + D[i][0];
				int ry = curr.y + D[i][1];
				if(Graph[rx][ry] == -1) {
					continue;
				}
				if(visited[rx][ry]) {
					continue;
				}
				if(rx < 0 || rx >= N || ry < 0 || ry >= M) {
					continue;
				}
				visited[rx][ry] = true;
				Graph[rx][ry] = 1;
				myqueue_2.push({rx, ry});
			}
		}
		if(!myqueue_2.empty()) bfs();
	}
	else{
		day++;
		while(!myqueue_2.empty()){
			Point curr = myqueue_2.front();
			myqueue_2.pop();

			for(int i=0; i<4; i++){
				int rx = curr.x + D[i][0];
				int ry = curr.y + D[i][1];
				if(Graph[rx][ry] == -1) {
					continue;
				}
				if(visited[rx][ry]) {
					continue;
				}
				if(rx < 0 || rx >= N || ry < 0 || ry >= M) {
					continue;
				}
				visited[rx][ry] = true;
				Graph[rx][ry] = 1;
				myqueue_1.push({rx, ry});
			}
		}
		if(!myqueue_1.empty()) bfs();
	}
}

void solve(){
	cin >> M >> N;
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
			int u;
			cin >> u;
			Graph[i][j] = u;
		}
	}
	if(isriped()){
		cout << "0\n";
		return;
	}
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
			if(Graph[i][j] == 1){
				myqueue_1.push({i, j});
				visited[i][j] = true;
			}
		}
	}
	bfs();
	if(isriped()){
		cout << day-1 << '\n';
	}
	else cout << "-1\n";
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}