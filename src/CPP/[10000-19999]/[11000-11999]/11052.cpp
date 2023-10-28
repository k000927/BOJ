#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int N;
	cin >> N;
	int* p = new int[N+1];
	int* max_value = new int[N+1];
	for(int i=1; i<=N; i++){
		cin >> p[i];
		max_value[i] = 0;
	}
	max_value = new int[N+1];
	max_value[0] = 0;
	max_value[1] = p[1];
	for(int i=2; i<=N; i++){
		for(int j=1; j<=i; j++){
			max_value[i] = max(max_value[i], p[j] + max_value[i-j]);
		}
	}
	cout << max_value[N] << endl;
}