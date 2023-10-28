#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int n;
	cin >> n;
	int* arr = new int[n+1];
	int* ans = new int[n+1];
	arr[2] = 3;
	ans[2] = arr[2];
	ans[0] = 1;
	for(int i=4; i<=n; i+=2){
		arr[i] = 2;
		ans[i] = 0;
	}
	for(int i=4; i<=n; i+=2){
		for(int j=0; j<=i; j+=2){
			ans[i] += (ans[j]*arr[i-j]);
		}
	}
	cout << ans[n] << endl;
}