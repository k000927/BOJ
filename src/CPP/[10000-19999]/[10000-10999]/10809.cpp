#include <iostream>
using namespace std;

int main(){
	string str;
	cin >> str;
	bool isexist = false;
	for(int i=0; i<26; i++){
		for(int j=0; j<str.size(); j++){
			if(str[j] == i+97){
				cout << j << " ";
				isexist = true;
				break;
			}
		}
		if(!isexist) cout << -1 << " ";
		else isexist = false;
	}
}