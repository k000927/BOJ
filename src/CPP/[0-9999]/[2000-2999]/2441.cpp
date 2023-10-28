#include <iostream>
using namespace std;

int main(){
	int n;
	cin >> n;
	for(int i=n; i>0; i--){
		string str = "";
		for(int j=0; j<i; j++){
			str += "*";
		}
		cout.width(n);
		cout << right << str << endl;
	}
}