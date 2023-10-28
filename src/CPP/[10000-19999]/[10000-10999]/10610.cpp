#include <iostream>
using namespace std;

bool zero = false;

void solve(){
	int num[10] = {0, };
	string str;
	cin >> str;
	int total = 0;
	for(int i=0; i<str.size(); i++){
		num[str[i]-48]++;
		total += (str[i]-48);
		if(!zero && str[i] == '0') zero = true;
	}
	if(!zero || total%3 != 0){
		cout << "-1\n";
		return;
	}
	else{
		for(int i=9; i>=0; i--){
			for(int j=0; j<num[i]; j++){
				cout << i;
			}
		}
		cout << '\n';
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}