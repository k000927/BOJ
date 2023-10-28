#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int n;
	cin >> n;
	int* arr = new int[n];
	int* v = new int[n];
	for(int i=0; i<n; i++){
		cin >> arr[i];
	}
	v[0] = arr[0];
	v[1] = v[0] + arr[1];
	v[2] = max(arr[0]+arr[2], arr[1]+arr[2]);
	for(int i=3; i<n; i++){
		v[i] = max(v[i-2]+arr[i], v[i-3]+arr[i-1]+arr[i]);
	}
	cout << v[n-1] << endl;
}