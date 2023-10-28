#include <iostream>
using namespace std;

static bool chessone[8][8];
static bool chesstwo[8][8];
static bool pan[8][8];

void init(){
	for(int i=0; i<8; i++){
		for(int j=0; j<8; j++){
			if(i%2 == 0){
				if(j%2 == 0){
					chessone[i][j] = true;
					chesstwo[i][j] = false;
				}
				else{
					chessone[i][j] = false;
					chesstwo[i][j] = true;
				}
			}
			else{
				if(j%2 == 0){
					chessone[i][j] = false;
					chesstwo[i][j] = true;
				}
				else{
					chessone[i][j] = true;
					chesstwo[i][j] = false;
				}
			}	
		}
	}
}

void makepan(bool** arr, int m, int n){
	for(int i=m; i<m+8; i++){
		for(int j=n; j<n+8; j++){
			pan[i-m][j-n] = arr[i][j];
		}
	}
}

int count(){
	int cntone = 0;
	int cnttwo = 0;
	for(int i=0; i<8; i++){
		for(int j=0; j<8; j++){
			if(pan[i][j] != chessone[i][j]) cntone++;
			if(pan[i][j] != chesstwo[i][j]) cnttwo++;
		}
	}
	int cnt = min(cntone, cnttwo);
	return cnt;
}

int main(){
	init();
	int m, n;
	int cnt;
	string str;
	cin >> m >> n;
	int min = m*n;
	bool** arr = new bool*[m];
	for(int i=0; i<m; i++){
		arr[i] = new bool[n];
	}
	for(int i=0; i<m; i++){
		cin >> str;
		for(int j=0; j<n; j++){
			if(str[j] == 'B') arr[i][j] = true;
			else {
				arr[i][j] = false;
			}
		}
	}
	for(int p=0; p<m-7; p++){
		for(int q=0; q<n-7; q++){
			makepan(arr, p, q);
			cnt = count();
			if(min > cnt) min = cnt;
		}
	}
	cout << min << endl;
}