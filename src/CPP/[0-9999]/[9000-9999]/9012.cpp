#include <iostream>
#include <stack>
using namespace std;

int main(){
	int n;
	cin >> n;
	for(int i=0; i<n; i++){
		string str;
		cin >> str;
		bool isvps = true;
		stack <char> s;
		for(int i=0; i<str.size(); i++){
			if(str[i] == '(') s.push('(');
			else{
				if(s.empty()) {
					isvps = false;
					break;
				}
				else{
					s.pop();
				}
			}
		}
		if(!s.empty()) isvps = false;
		if(isvps) cout << "YES" << endl;
		else cout << "NO" << endl;
	}
}