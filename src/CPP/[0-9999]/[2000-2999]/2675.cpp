#include <iostream>
using namespace std;

int main(){
	int n;
	cin >> n;
	for(int i=0; i<n; i++){
		string str, outp;
		int num;
		cin >> num >> str;
		for(int j=0; j<str.size(); j++){
			for(int k=0; k<num; k++){
				cout << str[j];
			}
		}
		cout << endl;
	}
}