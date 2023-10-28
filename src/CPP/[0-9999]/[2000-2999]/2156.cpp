#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int n;
	cin >> n;
	int* arr = new int[n];
	int* m = new int[n];
	for(int i=0; i<n; i++){
		cin >> arr[i];
	}
	m[0] = arr[0];
	m[1] = arr[1] + m[0];
	for(int i=2; i<n; i++){
		m[i] = max({m[i-1], m[i-2]+arr[i], m[i-3]+arr[i]+arr[i-1]});
	}
	cout << m[n-1] << endl;
}