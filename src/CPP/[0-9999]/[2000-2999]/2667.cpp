#include <iostream>
#include <cstring>
#include <stack>
#include <queue>
#include <vector>
#include <algorithm>
#define MAX_N 25
using namespace std;

struct Point{
	int x, y;
};

int N;
bool Graph[MAX_N][MAX_N] = {false, };
bool visited[MAX_N][MAX_N] = {false, };
queue<Point> myqueue;
int D[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
vector<int> danzi;


void bfs(int x, int y){
	if(visited[x][y] || !Graph[x][y]) return;
	else{
		danzi.back()++;
		visited[x][y] = true;
		myqueue.push({x, y});
		
		while(!myqueue.empty()){
			Point curr = myqueue.front();
			myqueue.pop();
			
			for(int i=0; i<4; i++){
				int nr = curr.x + D[i][0];
				int nc = curr.y + D[i][1];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(visited[nr][nc]) continue;
				if(!Graph[nr][nc]) continue;
				danzi.back()++;
				visited[nr][nc] = true;
				myqueue.push({nr, nc});
			}
		}
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	//cin.tie(nullptr);
	//cout.tie(nullptr);
	
	
	cin >> N;
	for(int i=0; i<N; i++){
		string str;
		cin >> str;
		for(int j=0; j<N; j++){
			if(str[j] == '1') Graph[i][j] = true;
			else Graph[i][j] = false;
		}
	}
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++){
			danzi.push_back(0);
			bfs(i, j);
			if(danzi.back() == 0) danzi.pop_back();
		}
	}
	sort(danzi.begin(), danzi.end());
	
	cout << danzi.size() << '\n';
	for(int i = 0; i<danzi.size(); i++){
		cout << danzi[i] << '\n';
	}
}