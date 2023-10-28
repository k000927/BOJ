#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int a, b, c;
	while(true){
		cin >> a >> b >> c;
		if(a==0 && b==0 && c==0) break;
		if(max({a, b, c}) == a){
			if(a*a == b*b + c*c) cout << "right" << endl;
			else cout << "wrong" << endl;
		}
		else if(max({a, b, c}) == b){
			if(b*b == a*a + c*c) cout << "right" << endl;
			else cout << "wrong" << endl;
		}
		else{
			if(c*c == a*a + b*b) cout << "right" << endl;
			else cout << "wrong" << endl;
		}
	}
}