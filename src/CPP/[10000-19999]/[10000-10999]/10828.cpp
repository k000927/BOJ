#include <iostream>
#include <stack>
using namespace std;

int main(){
	stack<int> s;
	int T;
	cin >> T;
	string op;
	int num;
	for(int z=0; z<T; z++){
		cin >> op;
		if(op == "push"){
			cin >> num;
			s.push(num);
		}
		else{
			if(op == "pop") {
				if(s.empty()) cout << -1 << endl;
				else{
					cout << s.top() << endl;
					s.pop();
				}
			}
			else if(op == "size") cout << s.size() << endl;
			else if(op == "empty") cout << s.empty() << endl;
			else {
				if(s.empty()) cout << -1 << endl;
				else{
					cout << s.top() << endl;
				}
			}
		}
	}
}