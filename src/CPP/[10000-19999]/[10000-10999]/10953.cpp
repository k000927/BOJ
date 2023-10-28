#include <iostream>
using namespace std;

int main(){
	int T;
	cin >> T;
	cin.ignore();
	string str, s1, s2;
	for(int i=0; i<T; i++){
		getline(cin, str);
		s1 = str.substr(0, str.find(","));
		s2 = str.substr(str.find(",") + 1);
		cout << stoi(s1) + stoi(s2) << endl;
	}
}