#include <iostream>
using namespace std;

int main(){
	int N, K;
	cin >> N >> K;
	long long int** arr = new long long int*[N+1];
	for(int i=0; i<N+1; i++){
		arr[i] = new long long int[K+1];
		arr[i][1] = 1;
	}
	for(int i=1; i<=K; i++){
		arr[0][i] = 1;
	}
	for(int i=1; i<=N; i++){
		for(int j=2; j<=K; j++){
			arr[i][j] = (arr[i-1][j]%1000000000 + arr[i][j-1]%1000000000)%1000000000;
		}
	}
	cout << arr[N][K] << endl;
}