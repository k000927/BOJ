#include <iostream>
using namespace std;

int main(){
	string s;
	cin >> s;
	int arr[26] = {0,};
	for(int i=0; i<s.size(); i++){
		arr[s[i]-97]++;
	}
	for(int i=0; i<26; i++){
		cout << arr[i] << " ";
	}
	cout << endl;
}