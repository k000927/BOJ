#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	
	int k, n;
	cin >> n >> k;
	int* arr = new int[n];
	for(int i=0; i<n; i++){
		cin >> arr[i];
	}
	sort(arr, arr+n);
	cout << arr[k-1] << endl;
}