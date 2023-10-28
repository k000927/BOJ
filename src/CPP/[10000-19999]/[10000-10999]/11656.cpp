#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	string str;
	cin >> str;
	int N = str.size();
	string* arr = new string[N];
	arr[0] = str;
	for(int i=1; i<N; i++){
		arr[i] = str.erase(0, 1);
	}
	sort(arr, arr+N);
	for(int i=0; i<N; i++){
		cout << arr[i] << endl;
	}
}