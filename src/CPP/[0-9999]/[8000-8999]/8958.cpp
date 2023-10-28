#include <iostream>
using namespace std;

int main(){
	int n;
	cin >> n;
	for(int i=0; i<n; i++){
		string str;
		cin >> str;
		int score = 0;
		int plus = 1;
		bool prev = false;
		for(int j=0; j<str.size(); j++){
			if(str[j] == 'O'){
				if(prev){
					score += ++plus;
				}
				else score += 1;
				prev = true;
			}
			else{
				plus = 1;
				prev = false;
			}
		}
		cout << score << endl;
	}
}