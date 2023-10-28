#include <iostream>
#include <cmath>
using namespace std;

int main(){
	int A, B, V;
	cin >> A >> B >> V;
	double i;
	if(V==A) i = 0;
	else if((V-A) < (A-B)) i = 1;
	else i = ceil((double)(V-A)/(double)(A-B));
	cout << (int)i+1 << endl;
}