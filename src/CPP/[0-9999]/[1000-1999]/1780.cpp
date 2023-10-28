#include <iostream>
using namespace std;

int N;
int minusone = 0;
int zero = 0;
int one = 0;
int** graph;


bool judge(int i_start, int i_end, int j_start, int j_end){
	int temp = graph[i_start][j_start];
	for(int i = i_start; i<=i_end; i++){
		for(int j= j_start; j<=j_end; j++){
			if(graph[i][j] != temp) return false;
		}
	}
	if(temp == -1) minusone++;
	else if(temp == 0) zero++;
	else one++;
	return true;
}

void dnc(int i_start, int i_end, int j_start, int j_end){
	if(judge(i_start, i_end, j_start, j_end)) return;
	else{
		int i_dist = (i_end - i_start + 1)/3;
		int j_dist = (j_end - j_start + 1)/3;
		dnc(i_start, i_start + i_dist-1, j_start, j_start + j_dist-1);
		dnc(i_start + i_dist, i_start + 2*i_dist-1, j_start, j_start + j_dist-1);
		dnc(i_start + 2*i_dist, i_end, j_start, j_start + j_dist-1);
		dnc(i_start, i_start + i_dist-1, j_start + j_dist, j_start + 2*j_dist-1);
		dnc(i_start + i_dist, i_start + 2*i_dist-1, j_start + j_dist, j_start + 2*j_dist-1);
		dnc(i_start + 2*i_dist, i_end, j_start + j_dist, j_start + 2*j_dist-1);
		dnc(i_start, i_start + i_dist-1, j_start + 2*j_dist, j_end);
		dnc(i_start + i_dist, i_start + 2*i_dist-1, j_start + 2*j_dist, j_end);
		dnc(i_start + 2*i_dist, i_end, j_start + 2*j_dist, j_end);
	}
}

void solve(){
	cin >> N;
	graph = new int*[N];
	for(int i=0; i<N; i++){
		graph[i] = new int[N];
	}
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++){
			cin >> graph[i][j];
		}
	}
	dnc(0, N-1, 0, N-1);
	cout << minusone << '\n' << zero << '\n' << one << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}