#include <iostream>
#include <string>
using namespace std;

int main(){
	string str;
	int count = 0;
	getline(cin, str);
	if(str == " ") {
		cout << 0 << endl;
		return 0;
	}
	for(int i=0; i<str.size(); i++){
		if(str[i] == ' '){
			if(i != 0 && i != str.size()-1) count++;
		}
	}
	if(str != "") count++;
	cout << count << endl;
}