#include <iostream>
using namespace std;

string rev(string str){
	string restr = str;
	for(int i=0; i<str.size(); i++){
		restr[i] = str[str.size()-i-1];
	}
	return restr;
}

int main(){
	string str;
	while(true){
		cin >> str;
		if(str =="0") return 0;
		if(str == rev(str) && str[0] != '0') cout << "yes" << endl;
		else cout << "no" << endl;
	}
}