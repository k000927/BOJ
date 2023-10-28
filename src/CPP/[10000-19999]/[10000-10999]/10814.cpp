#include <iostream>
#define N 100000

using namespace std;

class Member{
public:
	int index;
	int age;
	string name;
	Member(int index=0, int age=0, string name=""){
		this->index = index;
		this->age = age;
		this->name = name;
	}
};

Member arr[N];
Member result[N];

void merges(int left, int right) {
	int mid = (left + right) / 2;
	int i = left;
	int j = mid + 1;
	int k = left;

	while (i <= mid && j <= right) {
		if (arr[i].age > arr[j].age) {
			result[k++] = arr[j++];
		}
		else if(arr[i].age == arr[j].age){
			if(arr[i].index > arr[j].index) result[k++] = arr[j++];
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
	int age;
	string name;
	for(int z=0; z<T; z++){
		cin >> age >> name;
		arr[z] = Member(z, age, name);
	}
	if(T == 1) arr[0] = result[0];
	else partition(0, T-1);
	for(int i=0; i<T; i++){
		cout << result[i].age << " " << result[i].name << '\n';
	}
}