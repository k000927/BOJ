#include <iostream>
#include <cctype>
using namespace std;

int main(){
	string str;
	getline(cin, str);
	for(int i=0; i<str.size(); i++){
		if(isalpha(str[i])){
			if((str[i] >= 65 && str[i] <= 77) || (str[i] >= 97 && str[i] <= 109)) str[i] = str[i] + 13;
			else str[i] = str[i] - 13;
		}
	}
	cout << str << endl;
}