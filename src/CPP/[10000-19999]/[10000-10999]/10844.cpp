#include <iostream>
using namespace std;

int main(){
	long long arr[101][10];
	arr[1][0] = 0; arr[1][1] = 1; arr[1][2] = 1; arr[1][3] = 1; arr[1][4] = 1; arr[1][5] = 1; arr[1][6] = 1; arr[1][7] = 1; arr[1][8] = 1; arr[1][9] = 1;
	int N;
	long long sum = 0;
	cin >> N;
	for(int i=2; i<=N; i++){
		arr[i][0] = arr[i-1][1];
		for(int j=1; j<9; j++){
			arr[i][j] = (arr[i-1][j-1]%1000000000 + arr[i-1][j+1]%1000000000)%1000000000;
		}
		arr[i][9] = arr[i-1][8];
	}
	for(int i=0; i<10; i++){
		sum += (arr[N][i]%1000000000);
	}
	cout << sum%1000000000 << endl;
}