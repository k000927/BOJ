#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

void solve(){
	int A, B;
	long long int tenbase = 0;
	cin >> A >> B;
	int nod;		// number of digits = 자릿수
	cin >> nod;
	int* Abase = new int[nod]; // A진법 저장
	vector<int> Bbase;
	for(int i=0; i<nod; i++){
		cin >> Abase[i];
		tenbase += (Abase[i] * pow(A, nod-i-1));
	}
	while(true){
		if(tenbase >= B){
			Bbase.push_back(tenbase%B);
			tenbase /= B;
		}
		else{
			Bbase.push_back(tenbase);
			break;
		}
	}
	if(Bbase[Bbase.size()] == 0) Bbase.pop_back();
	for(int i = Bbase.size(); i>=0; i--){
		cout << Bbase[i] << " ";
	}
	cout << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}