#include <iostream>
#include <stack>
using namespace std;

int main(){
	string str;
	bool yesorno = true;
	while(true){
		stack<char> s;
		getline(cin, str);
		if(str == "."){
			return 0;
		}
		for(int i=0; i<str.size(); i++){
			if(str[i] == '(') s.push('(');
			else if(str[i] == '[') s.push('[');
			else if(str[i] == ')'){
				if(s.size() == 0 || s.top() != '('){
					yesorno = false;
					break;
				}
				else s.pop();
			}
			else if(str[i] == ']'){
				if(s.size() == 0 ||s.top() != '['){
					yesorno = false;
					break;
				}
				else s.pop();
			}
		}
		if(yesorno && s.empty()) cout << "yes" << '\n';
		else{
			yesorno = true;
			cout << "no" << '\n';
		}
	}
}