#include <iostream>
#include <cstring>
#include <queue>
#define MAX_N 50
using namespace std;

bool Graph[MAX_N][MAX_N];
bool visited[MAX_N][MAX_N];
struct Point{
	int x, y;
};
int w, h;
int D[8][2] = {{-1, 1}, {0, 1}, {1, 1}, {-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {1, -1}};
queue<Point> myqueue;
int sum;

void bfs(int x, int y){
	if(!Graph[x][y] || visited[x][y]) return;
	else{
		visited[x][y] = true;
		myqueue.push({x, y});
		sum++;
		
		while(!myqueue.empty()){
			Point curr = myqueue.front();
			myqueue.pop();
			
			for(int i=0; i<8; i++){
				int rx = curr.x + D[i][0];
				int ry = curr.y + D[i][1];
				if(rx < 0 || rx >= h || ry < 0 || ry >= w ) continue;
				if(visited[rx][ry]) continue;
				if(!Graph[rx][ry]) continue;
				visited[rx][ry] = true;
				myqueue.push({rx, ry});
			}
		}
	}
}

void solve(){
	while(true){
		cin >> w >> h;
		if(w == 0 && h == 0) return;
		sum = 0;
		memset(Graph, false, sizeof(Graph));
		memset(visited, false, sizeof(visited));
		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				int s;
				cin >> s;
				Graph[i][j] = s;
			}
		}
		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				bfs(i, j);
			}
		}
		cout << sum << '\n';
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}