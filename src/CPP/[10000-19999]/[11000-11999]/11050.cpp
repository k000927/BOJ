#include <iostream>
using namespace std;

int bin(int n, int k){
	int arr[11][11];
	for(int i=0; i<=n; i++){
		for(int j=0; j<=min(i, k); j++){
			if(j==0 || j==i) arr[i][j] = 1;
			else arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
		}
	}
	return arr[n][k];
}

int main(){
	int n, k;
	cin >> n >> k;
	cout << bin(n, k) << endl;
}