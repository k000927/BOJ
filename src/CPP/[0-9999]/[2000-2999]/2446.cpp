#include <iostream>
using namespace std;

int main(){
	int n;
	cin >> n;
	for(int i=n-1; i>0; i--){
		string str = "";
		for(int j=0; j<2*i+1; j++){
			str += "*";
		}
		cout.width(n+i);
		cout << right << str << endl;
	}
	for(int i=0; i<n; i++){
		string str = "";
		for(int j=0; j<2*i+1; j++){
			str += "*";
		}
		cout.width(n+i);
		cout << right << str << endl;
	}
}