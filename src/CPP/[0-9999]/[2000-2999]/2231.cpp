#include <iostream>
using namespace std;

int main(){
	int n;
	cin >> n;
	for(int i=1; i<n; i++){
		int ans = i;
		string str = to_string(i);
		for(int j=0; j<str.size(); j++){
			ans += (str[j]-48);
		}
		if(ans == n) {
			cout << i << endl;
			return 0;
		}
	}
	cout << 0 << endl;
}