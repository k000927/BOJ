#include <iostream>
#include <algorithm>
#include <cmath>
#include <climits>
using namespace std;

int main(){
	int N;
	cin >> N;
	int* arr = new int[N+1];
	for(int i=1; i<=N; i++){
		arr[i] = INT_MAX;
	}
	arr[1] = 1;
	for(int i=2; i<=sqrt(N); i++){
		arr[i*i] = 1;
	}
	for(int i=2; i<=N; i++){
		for(int j=1; j*j<i; j++){
			arr[i] = min(arr[i], arr[i-j*j] + arr[j*j]);
		}
	}
	cout << arr[N] << endl;
}