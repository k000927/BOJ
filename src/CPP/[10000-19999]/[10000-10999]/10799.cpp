#include <iostream>
using namespace std;

int main(){
	string str;
	cin >> str;
	int push = 0;
	int pop = 0;
	int ans = 0;
	for(int i=0; i<str.size(); i++){
		if(str[i] == '(' && str[i+1] == ')'){
			str.replace(i, 2, "X");
		}
	}
	for(int i=0; i<str.size(); i++){
		if(str[i] == 'X'){
			ans += push;
		}
		else if(str[i] == '('){
			push++;
		}
		else{
			pop++;
			push--;
		}
	}
	cout << ans+pop << endl;
}