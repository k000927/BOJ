#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int arr[1001];
	arr[1] = 1;
	arr[2] = 2;
	int N;
	cin >> N;
	for(int i=3; i<=N; i++){
		arr[i] = arr[i-2]%10007 + arr[i-1]%10007;
	}
	cout << arr[N]%10007 << endl;
}