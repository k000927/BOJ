#include <iostream>
using namespace std;

int main(){
	int squared [100];
	for(int i=0; i<=100; i++){
		squared[i] = i*i;
	}
	int m, n;
	int sum = 0;
	cin >> m;
	cin >> n;
	int k = m;
	bool isfirst = true;
	int min;
	for(int i=m; i<=n; i++){
		for(int j=0; j<=100; j++){
			if(squared[j] == i) {
				if(isfirst) {
					min = i;
					isfirst = false;
				}
				sum += i;
			}
		}
	}
	if(isfirst) cout << -1 << endl;
	else {
		cout << sum << endl << min << endl;
	}
}