#include <iostream>
using namespace std;

int main(){
	int n;
	cin >> n;
	int sum = 0;
	bool isdem = true;
	for(int i=0; i<n; i++){
		int x;
		cin >> x;
		for(int j=2; j<x; j++){
			if(x%j == 0){
				isdem = false;
				break;
			}
		}
		if(isdem){
			if(x != 1) sum++;
		}
		else isdem = true;
	}
	cout << sum << endl;
}