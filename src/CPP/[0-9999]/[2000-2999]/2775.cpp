#include <iostream>
using namespace std;

int arr[15][14];

int numberof(int k, int n){
	for(int i=0; i<=k; i++){
		for(int j=1; j<=n; j++){
			if(i==0) arr[i][j] = j;
			else {
				if(j==1) arr[i][j] = 1;
				else arr[i][j] = (arr[i][j-1] + arr[i-1][j]);
			}
		}
	}
	return arr[k][n];
}

int main(){
	int T, k, n; // k는 층수, n은 호수
	cin >> T;
	for(int i=0; i<T; i++){
		cin >> k >> n;
		cout << numberof(k, n) << endl;
	}
}