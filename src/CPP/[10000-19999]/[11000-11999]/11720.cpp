#include <iostream>
using namespace std;

int main(){
	int n;
	char c[100];
	cin >> n;
	int sum = 0;
	cin.ignore();
	for(int i=0; i<n; i++){
		cin.get(c[i]);
		sum += ((int)c[i] - 48);
	}
	cout << sum << endl;
}