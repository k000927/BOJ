#include <iostream>
using namespace std;

int main(){
	string line = "";
	while(true){
		string str;
		getline(cin, str);
		if(str == ""){
			cout << line;
			return 0;
		}
		line += str;
		line += '\n';
	}
}