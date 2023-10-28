#include <iostream>
using namespace std;

int main(){
	int n;
	cin >> n;
	for(int i=0; i<n-1; i++){
		string str = "";
		if(i == 0) str = "*";
		else{
			str += "*";
			for(int j=1; j<2*i; j++){
				str += " ";
			}
			str += "*";
		}
		cout.width(n+i);
		cout << right << str << endl;
	}
	string str;
	for(int i=0; i<2*n-1; i++){
		str += "*";
	}
	cout << str << endl;
}