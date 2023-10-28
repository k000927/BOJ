#include <iostream>
using namespace std;

int main(){
	int arr[8];
	bool asc = true;
	bool des = true;
	cin >> arr[0] >> arr[1] >> arr[2] >> arr[3] >> arr[4] >> arr[5] >> arr[6] >> arr[7];
	for(int i=1; i<8; i++){
		if(arr[i] > arr[i-1]) des = false;
		else asc = false;
	}
	if(asc) cout << "ascending" << endl;
	else if(des) cout << "descending" << endl;
	else cout << "mixed" << endl;
}