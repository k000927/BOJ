#include <iostream>
using namespace std;

int N;
string* arr;

void star(int x, int y, int h){
	if(h == 3){
		arr[x][y] = '*';
		arr[x+1][y-1] = '*';
		arr[x+1][y+1] = '*';
		arr[x+2][y-2] = '*';
		arr[x+2][y-1] = '*';
		arr[x+2][y] = '*';
		arr[x+2][y+1] = '*';
		arr[x+2][y+2] = '*';
	}
	else{
		star(x, y, h/2);
		star(x+h/2, y-h/2, h/2);
		star(x+h/2, y+h/2, h/2);
	}
}

void solve(){
	cin >> N;
	arr = new string[N];
	for(int i=0; i<N; i++){
		arr[i] = "";
		for(int j=0; j<2*N+1; j++){
			arr[i] += ' ';
		}
	}
	star(0, N-1, N);
	for(int i=0; i<N; i++){
		cout << arr[i] << '\n';
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}