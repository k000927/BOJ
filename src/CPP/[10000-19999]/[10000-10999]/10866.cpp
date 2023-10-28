#include <iostream>
#include <deque>
using namespace std;

deque<int> d;

int main(){
	int T;
	cin >> T;
	string op;
	int num;
	for(int z=0; z<T; z++){
		cin >> op;
		if(op == "push_front"){
			cin >> num;
			d.push_front(num);
		}
		else if(op == "push_back"){
			cin >> num;
			d.push_back(num);
		}
		else{
			if(op == "pop_front") {
				if(d.empty()) cout << -1 << endl;
				else{
					cout << d.front() << endl;
					d.pop_front();
				}
			}
			else if(op == "pop_back") {
				if(d.empty()) cout << -1 << endl;
				else{
					cout << d.back() << endl;
					d.pop_back();
				}
			}
			else if(op == "size") cout << d.size() << endl;
			else if(op == "empty") cout << d.empty() << endl;
			else if(op == "front") {
				if(d.empty()) cout << -1 << endl;
				else{
					cout << d.front() << endl;
				}
			}
			else if(op == "back"){
				if(d.empty()) cout << - 1 << endl;
				else{
					cout << d.back() << endl; 
				}
			}
		}
	}
}