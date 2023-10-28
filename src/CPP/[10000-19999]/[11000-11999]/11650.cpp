#include <iostream>
#define N 100000

using namespace std;

class Point{
	int x;
	int y;
public:
	
	Point(int x=0, int y=0){
		this->x = x;
		this->y = y;
	}
	int getX(){ return x; }
	int getY(){ return y; }
	void print(){
		cout << x << " " << y << '\n';
	}
};

Point arr[N];
Point result[N];

void merges(int left, int right) {
	int mid = (left + right) / 2;
	int i = left;
	int j = mid + 1;
	int k = left;

	while (i <= mid && j <= right) {
		if (arr[i].getX() > arr[j].getX()) {
			result[k++] = arr[j++];
		}
		else if(arr[i].getX() == arr[j].getX()){
			if(arr[i].getY() > arr[j].getY()) result[k++] = arr[j++];
			else result[k++] = arr[i++];
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
	cout.tie(nullptr);
	
	int T;
	cin >> T;
	int x, y;
	for(int z=0; z<T; z++){
		cin >> x >> y;
		arr[z] = Point(x, y);
	}
	if(T == 1) arr[0] = result[0];
	else partition(0, T-1);
	for(int i=0; i<T; i++){
		result[i].print();
	}
}