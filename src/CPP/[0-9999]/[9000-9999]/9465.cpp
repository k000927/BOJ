#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int T, N;
	int** arr;
	int** value;
	arr = new int*[2];
	value = new int*[2];
	cin >> T;
	for(int z=0; z<T; z++){
		cin >> N;
		arr[0] = new int[N];
		arr[1] = new int[N];
		value[0] = new int[N];
		value[1] = new int[N];
		for(int i=0; i<N; i++){
			cin >> value[0][i];
		}
		for(int i=0; i<N; i++){
			cin >> value[1][i];
		}
		arr[0][0] = value[0][0];
		arr[1][0] = value[1][0];
		arr[0][1] = arr[1][0] + value[0][1];
		arr[1][1] = arr[0][0] + value[1][1];
		for(int i=2; i<=N; i++){
			arr[0][i] = max(arr[1][i-1] + value[0][i], arr[1][i-2] + value[0][i]);
			arr[1][i] = max(arr[0][i-1] + value[1][i], arr[0][i-2] + value[1][i]);
		}
		cout << max(arr[0][N-1], arr[1][N-1]) << endl;
	}
}