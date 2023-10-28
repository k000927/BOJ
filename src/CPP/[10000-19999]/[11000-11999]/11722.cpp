#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
	int n, temp;
	cin >> n;
	int* v = new int[n];
	int* arr = new int[n];
	for(int i=0; i<n; i++){
		cin >> v[i];
	}
	int ans = 0;
	for(int i=0; i<n; i++){
		arr[i] = 1;
		for(int j=0; j<i; j++){
			if(v[i] < v[j]){
				arr[i] = max(arr[i], arr[j]+1);
			}
		}
		ans = max(arr[i], ans);
	}
	cout << ans << endl;
}