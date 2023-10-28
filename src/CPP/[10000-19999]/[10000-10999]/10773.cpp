#include <iostream>
#include <stack>
using namespace std;

int main(){
	int n;
	int sum=0;
	cin >> n;
	stack <int> st;
	for(int i=0; i<n; i++){
		int x;
		cin >> x;
		if(x == 0) st.pop();
		else st.push(x);
	}
	if(st.empty()) cout << 0 << endl;
	else{
		while(!st.empty()){
			sum += st.top();
			st.pop();
		}
		cout << sum << endl;
	}
}