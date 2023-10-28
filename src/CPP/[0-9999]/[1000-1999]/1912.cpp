#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;

int main(){
	int n;
	cin >> n;
	int* arr = new int[n];
	int* sum = new int[n];
	for(int i=0; i<n; i++){
		cin >> arr[i];
	}
	int ans = arr[0];
	sum[0] = arr[0];
	for(int i=1; i<n; i++){
		sum[i] = max(arr[i], sum[i-1] + arr[i]);
		ans = max(ans, sum[i]);
	}
	cout << ans << endl;
}