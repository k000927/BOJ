#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int T;
	int a = 4;
	int b = 8;
	cin >> T;
	long long int* arr = new long long int[101];
	arr[1] = 1;
	arr[2] = 1;
	arr[3] = 1;
	arr[4] = 2;
	arr[5] = 2;
	arr[6] = 3;
	arr[7] = 4;
	arr[8] = 5;
	for(int i=9; i<=100; i++){
		arr[i] = arr[a++] + arr[b++];
	}
	for(int z=0; z<T; z++){
		int n;
		cin >> n;
		cout << arr[n] << endl;
	}
}