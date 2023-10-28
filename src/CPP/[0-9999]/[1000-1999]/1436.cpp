#include <iostream>
using namespace std;

int main(){
	int N;
	cin >> N;
	int* arr = new int[N];
	int index=0;
	for(int i=666; index<N; i++){
		string str = to_string(i);
		if(str.find("666") != -1) arr[index++] = i;
	}
	cout << arr[N-1] << endl;
}