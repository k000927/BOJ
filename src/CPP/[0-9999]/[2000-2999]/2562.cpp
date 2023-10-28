#include <iostream>
using namespace std;

int main(){
	int arr[9];
	for(int i=0; i<9; i++){
		cin >> arr[i];
	}
	int max = 0;
	for(int i=0; i<9; i++){
		if(arr[max] < arr[i]) max = i;
	}
	cout << arr[max] << endl << max+1 << endl;
}