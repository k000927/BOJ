#include <iostream>
using namespace std;

int main(){
	int a, b, c;
	cin >> a;
	cin >> b;
	cin >> c;
	string str = to_string(a*b*c);
	int arr[10] = {0, };
	for(int i=0; i<str.size(); i++){
		arr[(int)str[i]-48]++;
	}
	for(int i=0; i<10; i++){
		cout << arr[i] << endl;
	}
}