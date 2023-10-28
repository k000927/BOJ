#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>
#define MAX_N 100
using namespace std;

int N;
int num_of_sum = 1;
int shortest = MAX_N*2;
int Graph[MAX_N][MAX_N] = {0, };
bool visited[MAX_N][MAX_N] = {false, };
struct Point{
	int x, y, dis;
};
int D[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
queue<Point> myqueue;

void sum(int x, int y){
	if(visited[x][y] || Graph[x][y] == 0) return;
	else{
		visited[x][y] = true;
		Graph[x][y] = num_of_sum;
		myqueue.push({x, y, 0});
		while(!myqueue.empty()){
			Point curr = myqueue.front();
			myqueue.pop();
			for(int i=0; i<4; i++){
				int rx = curr.x + D[i][0];
				int ry = curr.y + D[i][1];
				if(rx < 0 || rx >= N || ry < 0 || ry >= N) continue;
				if(visited[rx][ry]) continue;
				if(Graph[rx][ry] == 0) continue;
				visited[rx][ry] = true;
				Graph[rx][ry] = num_of_sum;
				myqueue.push({rx, ry, 0});
			}
		}
		num_of_sum++;
	}
}

void bfs(int x, int y){
	if(Graph[x][y] == 0) return;
	else{
		visited[x][y] = true;
		myqueue.push({x, y, 0});
		while(!myqueue.empty()){
			Point curr = myqueue.front();
			myqueue.pop();
			for(int i=0; i<4; i++){
				int rx = curr.x + D[i][0];
				int ry = curr.y + D[i][1];
				if(Graph[x][y] == Graph[rx][ry]) continue;
				if(rx < 0 || rx >= N || ry < 0 || ry >= N) continue;
				if(visited[rx][ry]) continue;
				if(Graph[rx][ry] != Graph[x][y] && Graph[rx][ry] != 0){
					shortest = min(shortest, curr.dis);
					continue;
				}
				visited[rx][ry] = true;
				myqueue.push({rx, ry, curr.dis+1});
			}
		}
	}
}

void solve(){
	cin >> N;
	for(int j=0; j<N; j++){
		for(int i=0; i<N; i++){
			int u;
			cin >> u;
			Graph[i][j] = u;
		}
	}
	for(int j=0; j<N; j++){
		for(int i=0; i<N; i++){
			sum(i, j);
		}
	}
	for(int j=0; j<N; j++){
		for(int i=0; i<N; i++){
			memset(visited, false, sizeof(visited));
			bfs(i, j);
		}
	}
	cout << shortest << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}