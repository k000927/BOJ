#include <iostream>
using namespace std;

int main(){
	int n, m;
	cin >> n >> m;
	int* arr = new int[n];
	for(int i=0; i<n; i++){
		cin >> arr[i];
	}
	int ans = 0;
	int temp;
	for(int i=0; i<n-2; i++){
		for(int j=i+1; j<n-1; j++){
			for(int k=j+1; k<n; k++){
				temp = arr[i] + arr[j] + arr[k];
				if((temp > ans) && (temp <= m)) ans = temp;
			}
		}
	}
	cout << ans << endl;
}