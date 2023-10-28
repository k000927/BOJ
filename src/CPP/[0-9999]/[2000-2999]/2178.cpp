#include <iostream>
#include <cstring>
#include <stack>
#include <queue>
#define MAX 101
using namespace std;

int N, M;
bool Graph[MAX][MAX];
int D[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
struct Point{
	int x, y, dis;
};

int bfs(Point P){
	bool visited[MAX][MAX] = {false, };
	queue<Point> myqueue;
	visited[P.x][P.y] = true;
	myqueue.push(P);
	
	while(!myqueue.empty()){
		Point curr = myqueue.front();
		myqueue.pop();
				
		
		for(int i=0; i<4; i++){
			int rx = curr.x + D[i][0];
			int ry = curr.y + D[i][1];
			if(rx < 0 || rx >= N+1 || ry < 0 || ry >= M+1){
				continue;
			}
			if(visited[rx][ry]){
				continue;
			}
			if(!Graph[rx][ry]){
				continue;
			}
			if(rx == N && ry == M){
				return curr.dis + 1;
			}
			visited[rx][ry] = true;
			myqueue.push({rx, ry, curr.dis + 1});
		}
	}
	return -1;
}

void solve(){
	cin >> N >> M;
	for(int i=1; i<=N; i++){
		string str;
		cin >> str;
		for(int j=1; j<=M; j++){
			if(str[j-1] == '1') Graph[i][j] = true;
			else Graph[i][j] = false;
		}
	}
	cout << bfs({1, 1, 1}) << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}