#include <iostream>
#include <cmath>
using namespace std;

int main(){
	int L;
	long long sum = 0;
	long long r = 1;
	string str;
	cin >> L >> str;
	for(int i=0; i<L; i++){
		sum = (sum + (str[i]-96)*r)%1234567891;
		r = (r*31)%1234567891;
	}
	cout << sum << endl;
}