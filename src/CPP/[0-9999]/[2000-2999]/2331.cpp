#include <iostream>
#include <cmath>
#include <vector>
#define MAX 300000
using namespace std;


bool check[MAX] = { false, };
vector<int> v;	
int A, P;

int next(int x, int P){
	int num = 0;
	for(int i=6; i>=0; i--){
		int ten = pow(10, i);
		num += pow(x/ten, P);
		x -= (x/ten * ten);
	}
	return num;
}

void solve(){
	cin >> A >> P;
	v.push_back(A);
	check[A] = true;
	int i = 0;
	while(true){
		int n = next(v[i++], P);
		if(check[n]){
			int j=0;
			while(true){
				if(v[j] == n){
					cout << j << '\n';
					return;
				}
				else{
					j++;
				}
			}
		}
		else{
			check[n] = true;
			v.push_back(n);
		}
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}