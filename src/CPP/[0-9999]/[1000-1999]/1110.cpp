#include <iostream>
using namespace std;

int main(){
	int a, b, newint;
	int count = 0;
	cin >> a;
	while(true){
		if(a<10){
			b = a;
		}
		else{
			b = a/10 + a%10;
		}
		newint = a%10 + b%10;
		count++;
		if(a == newint) break;
		a = newint;
	}
	cout << count << endl;
}