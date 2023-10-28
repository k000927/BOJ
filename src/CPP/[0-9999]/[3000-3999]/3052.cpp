#include <iostream>
using namespace std;

int main(){
	int a[10];
	for(int i=0; i<10; i++){
		cin >> a[i];
	}
	int b[10] = {0, };
	int cycle = 0;
	int index = 0;
	bool isexist = false;
	while(cycle<10){
		int temp = a[cycle]%42;
		for(int k=0; k<index; k++){
			if(b[k] == temp) {
				isexist = true;
				break;
			}
		}
		if(!isexist) {
			b[index++] = temp;
		}
		else{
			isexist = false;
		}
		cycle++;
	}
	cout << index << endl;
}