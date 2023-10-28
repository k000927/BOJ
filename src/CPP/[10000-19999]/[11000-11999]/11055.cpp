#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int n;
	cin >> n;
	int* arr = new int[n];
	int* sum = new int[n];
	for(int i=0; i<n; i++){
		cin >> arr[i];
	}
	int ans = -1;
	for(int i=0; i<n; i++){
		sum[i] = arr[i];
		for(int j=0; j<i; j++){
			if(arr[i] > arr[j]) sum[i] = max(sum[i], sum[j]+arr[i]);
		}
		ans = max(ans, sum[i]);
	}
	cout << ans << endl;
}