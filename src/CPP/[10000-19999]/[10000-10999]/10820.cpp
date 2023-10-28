#include <iostream>
using namespace std;

int main(){
	string str;
	while(getline(cin, str)){
		int small = 0;
		int big = 0;
		int number = 0;
		int space = 0;
		for(int i=0; i<str.size(); i++){
			if(str[i] <= 122 && str[i] >= 97) small++;
			else if(str[i] <= 90 && str[i] >= 65) big++;
			else if(str[i] == 32) space++;
			else if(str[i] <= 57 && str[i] >=48) number++;
		}
		cout << small << " " << big << " " << number << " " << space << endl;
	}
}