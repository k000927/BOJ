#include <iostream>
#include <climits>
using namespace std;

int main(){
	int n, i, j, maxi, maxj, min;
	cin >> n;
	maxi = n/3;
	maxj = n/5;
	min = INT_MAX;
	for(int i=0; i<=maxi; i++){
		for(int j=0; j<=maxj; j++){
			if(3*i+5*j == n){
				if(min>i+j) min = i+j;
			}
			else if(3*i+5*j > n) break;
		}
	}
	if(min == INT_MAX) cout << -1 << endl;
	else cout << min << endl;
}