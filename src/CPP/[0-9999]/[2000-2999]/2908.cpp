#include <iostream>
#include <string>
using namespace std;

int main(){
	string a, b;
	cin >> a >> b;
	string rea = "";
	string reb = "";
	for(int i=a.size()-1; i>=0; i--){
		rea += a[i];
	}
	for(int i=b.size()-1; i>=0; i--){
		reb += b[i];
	}
	if(reb > rea) cout << reb << endl;
	else cout << rea << endl;
}