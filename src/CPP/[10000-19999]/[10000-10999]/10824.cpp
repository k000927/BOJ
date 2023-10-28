#include <iostream>
using namespace std;

int main(){
	string A, B, C, D;
	cin >> A >> B >> C >> D;
	A += B;
	C += D;
	cout << stoll(A) + stoll(C) << endl;
}