#include <iostream>
#include <string>
using namespace std;

int main(){
	int n , p;
	cin >> n;
	string* list = new string[n];
	for(int i=0; i<n; i++){
		cin >> p;
		string* price = new string[p];
		string* name = new string[p];
		string str = "";
		int max = 0;
		cin.ignore();
		for(int j=0; j<p; j++){
			getline(cin, str);
			int index = str.find(" ");
			price[j] = str.substr(0, index);
			if(price[max] < price[j]) max = j;
			name[j] = str.substr(index+1);
		}
		list[i] = name[max];
	}
	for(int i=0; i<n; i++){
		cout << list[i] << endl;
	}
}