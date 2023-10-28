#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int n;
	cin >> n;
	int* arr = new int[n];
	int* bigger = new int[n];
	int* smaller = new int[n];
	int ans = 0;
	for(int i=0; i<n; i++){
		cin >> arr[i];
	}
	for(int i=n-1; i>=0; i--){
		smaller[i] = 1;
		for(int j=n-1; j>i; j--){
			if(arr[i] > arr[j]) smaller[i] = max(smaller[i], smaller[j]+1);
		}
	}
	for(int i=0; i<n; i++){
		bigger[i] = 1;
		for(int j=0; j<i; j++){
			if(arr[i] > arr[j]){
				bigger[i] = max(bigger[i], bigger[j]+1);
			}
		}
		ans = max(ans, smaller[i]+bigger[i]);
	}
	cout << ans-1 << endl;
}