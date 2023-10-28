#include <iostream>
#define N 1000000

using namespace std;

int arr[N];
int result[N];

void merges(int left, int right) {
	int mid = (left + right) / 2;
	int i = left;
	int j = mid + 1;
	int k = left;

	while (i <= mid && j <= right) {
		if (arr[i] > arr[j]) {
			result[k++] = arr[j++];
		}
		else {
			result[k++] = arr[i++];
		}
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


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int T;
	cin >> T;
	for(int i=0; i<T; i++){
		cin >> arr[i];
	}
	if(T==1) result[0] = arr[0];
	else partition(0, T-1);
	for(int i=0; i<T; i++){
		cout << result[i] << '\n';
	}
	return 0;
}