#include <iostream>
using namespace std;

int N;
string* arr;

void paint(int x1, int y1, int x2, int y2){
	if(x2 - x1 == 2){
		arr[x1] += '*'; arr[x1] += '*'; arr[x1] += '*'; arr[x1+1] += '*'; arr[x1+1] += ' '; arr[x1+1] += '*'; arr[x1+2] += '*'; arr[x1+2] += '*'; arr[x1+2] += '*';
	}
	else{
		int x_dif = (x2 - x1 + 1)/3;
		int y_dif = (y2 - y1 + 1)/3;
		paint(x1, y1, x1+x_dif-1, y1+y_dif-1);
		paint(x1+x_dif, y1, x1+x_dif*2-1, y1+y_dif-1);
		paint(x1+2*x_dif, y1, x2, y1+y_dif-1);
		paint(x1, y1+y_dif, x1+x_dif-1, y1+2*y_dif-1);
		for(int i=x1+x_dif; i<=x1+2*x_dif-1; i++){
			for(int j=y1+y_dif; j<=y1+2*x_dif-1; j++){
				arr[i] += ' ';
			} 
		}
		paint(x1+2*x_dif, y1+y_dif, x2, y1+2*y_dif-1);
		paint(x1, y1+2*y_dif, x1+x_dif-1, y2);
		paint(x1+x_dif, y1+2*y_dif, x1+x_dif*2-1, y2);
		paint(x1+2*x_dif, y1+2*y_dif, x2, y2);
	}
}

void solve(){
	cin >> N;
	arr = new string[N];
	paint(0, 0, N-1, N-1);
	for(int i=0; i<N; i++){
		cout << arr[i] << "\n";
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}