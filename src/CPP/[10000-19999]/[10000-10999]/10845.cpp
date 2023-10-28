#include <iostream>
#include <queue>
using namespace std;

queue<int> q;

int main(){
	int T;
	cin >> T;
	string op;
	int num;
	for(int z=0; z<T; z++){
		cin >> op;
		if(op == "push"){
			cin >> num;
			q.push(num);
		}
		else{
			if(op == "pop") {
				if(q.empty()) cout << -1 << endl;
				else{
					cout << q.front() << endl;
					q.pop();
				}
			}
			else if(op == "size") cout << q.size() << endl;
			else if(op == "empty") cout << q.empty() << endl;
			else if(op == "front") {
				if(q.empty()) cout << -1 << endl;
				else{
					cout << q.front() << endl;
				}
			}
			else if(op == "back"){
				if(q.empty()) cout << - 1 << endl;
				else{
					cout << q.back() << endl; 
				}
			}
		}
	}
}