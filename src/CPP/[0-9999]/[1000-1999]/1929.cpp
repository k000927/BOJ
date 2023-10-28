#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

int main(){
	int n, m;
	cin >> n >> m;
	vector<bool> v;
	vector<int> prime;
	v.push_back(false);
	v.push_back(false);
	for(int i=2; i<m+1; i++){
		v.push_back(true);
	}
	for(int i=2; i<m+1; i++){
		if(v[i] == true) {
			if(i>=n) prime.push_back(i);
			if(i<=sqrt(m)){
				for(int j=2; i*j<m+1; j++){
					v[i*j] = false;
				}
			}
		}
	}
	for(int i=0; i<prime.size(); i++){
		cout << prime[i] << '\n';
	}
}