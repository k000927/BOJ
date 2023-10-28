#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int numberoftwo(int n){
	int notwo = 0;
	for(int i=1; pow(2, i)<=n; i++){
		notwo += n/pow(2, i);
	}
	return notwo;
}

int numberoffive(int n){
	int nofive = 0;
	for(int i=1; pow(5, i)<=n; i++){
		nofive += n/pow(5, i);
	}
	return nofive;
}

void solve(){
	int n, m;
	int ans;
	cin >> n >> m;
	int nofive = (numberoffive(n) - numberoffive(m) - numberoffive(n-m));
	int notwo = (numberoftwo(n) - numberoftwo(m) - numberoftwo(n-m));
	cout << min(nofive, notwo) << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}