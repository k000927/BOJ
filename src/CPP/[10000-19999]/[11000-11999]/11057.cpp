#include <iostream>
using namespace std;

int main(){
	int N;
	cin >> N;
	long long arr[1001][10];
	long long sum = 0;
	for(int i=0; i<10; i++){
		arr[1][i] = 1;
	}
	for(int i=2; i<=N; i++){
		arr[i][0] = 1;
		for(int j=1; j<10; j++){
			arr[i][j] = (arr[i][j-1]%10007 + arr[i-1][j]%10007)%10007;
		}
	}
	for(int i=0; i<=9; i++){
		sum += arr[N][i];
	}
	cout << sum%10007 << endl;
}