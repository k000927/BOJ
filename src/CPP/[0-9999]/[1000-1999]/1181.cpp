#include <iostream>
#define N 20001
using namespace std;

string arr[N];
string result[N];

void merges(int left, int right) {
	int mid = (left + right) / 2;
	int i = left;
	int j = mid + 1;
	int k = left;

	while (i <= mid && j <= right) {
		if (arr[i].size() > arr[j].size()) {
			result[k++] = arr[j++];
		}
		else if(arr[i].size() == arr[j].size()){
			if(arr[i] > arr[j]) result[k++] = arr[j++];
			else if(arr[i] == arr[j]) result[k++] = arr[j++];
			else result[k++] = arr[i++];
		}
		else result[k++] = arr[i++];
	}

	if (i > mid) {
		while (j <= right) {
			result[k++] = arr[j++];
		}
	}
	else {
		while (i <= mid) {
			result[k++] = arr[i++];
		}
	}

	for (int a = left; a <= right; a++) {
		arr[a] = result[a];
	}
}

void partition(int left, int right) {
	int mid;
	if (left < right) {
		mid = (left + right) / 2;
		partition(left, mid);
		partition(mid + 1, right);
		merges(left, right);
	}
}

int main()
{
	int T;
	cin >> T;
	for(int z=0; z<T; z++){
		cin >> arr[z];
	}
    partition(0, T-1);
	if(T==1) result[0] = arr[0];
	int i=0;
	while(i<T){
		if(result[i] != result[i-1]) cout << result[i++] << endl;
		else i++;
	}
}