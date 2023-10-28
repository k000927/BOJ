#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	int N;
	int arr[10000] = {0,};
	int temp;
	cin >> N;
	for(int i=0; i<N; i++){
		cin >> temp;
		arr[temp-1]++;
	}
	for(int i=0; i<10000; i++){
		if(arr[i] != 0){
			for(int z=0; z<arr[i]; z++){
				cout << i+1 << '\n';
			}
		}
	}
}