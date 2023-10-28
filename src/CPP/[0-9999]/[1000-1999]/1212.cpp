#include <iostream>
using namespace std;

string eight_to_two(char c){
	if(c == '0') return "000";
	else if (c == '1') return "001";
	else if (c == '2') return "010";
	else if (c == '3') return "011";
	else if (c == '4') return "100";
	else if (c == '5') return "101";
	else if (c == '6') return "110";
	else return "111";
}

void solve(){
	string eight, two;
	cin >> eight;
	for(int i=0; i<eight.size(); i++){
		two += eight_to_two(eight[i]);
	}
	while(true){
		if(two[0] == '0' && two != "0") two.erase(0, 1);
		else break;
	}
	cout << two << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}