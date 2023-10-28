#include <iostream>
using namespace std;

int main(){
	int n;
	cin >> n;
	int sum = 1;
	int i;
	for(i=0; ;i++){
		if(sum>=n) break;
		sum += 6*(i+1);
	}
	cout << i+1 << endl;
}