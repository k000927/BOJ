#include <iostream>
using namespace std;

int main(){
	int n;
	cin >> n;
	string space;
	for(int i=0; i<2*n; i++) {
		space += ' ';
	}
	for(int i=1; i<n; i++){
		string str = space;
		for(int j=0; j<i; j++){
			str[j] = '*';
			str[2*n - j - 1] = '*';
		}
		cout << str << endl;
	}
	for(int i=n; i>0; i--){
		string str = space;
		for(int j=0; j<i; j++){
			str[j] = '*';
			str[2*n - j - 1] = '*';
		}
		cout << str << endl;
	}
}