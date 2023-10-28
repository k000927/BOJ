#include <iostream>
#include <cctype>
using namespace std;

int main(){
	string str;
	cin >> str;
	int alpha[26] = {0, };
	for(int i=0; i<str.size(); i++){
		alpha[tolower(str[i])-97]++;
	}
	
	int max = 0;
	int index;
	bool same = false;
	
	for(int i=0; i<26; i++){
		if(max < alpha[i]){
			max = alpha[i];
			index = i;
			same = false;
		}
		else if(max == alpha[i]) same = true;
	}
	if(same) cout << "?" << endl;
	else {
		cout << (char)toupper(index+97) << endl;
	}
}