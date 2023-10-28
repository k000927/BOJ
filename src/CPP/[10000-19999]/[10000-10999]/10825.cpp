#include <iostream>
#include <algorithm>
using namespace std;

class Student{
public:
	string name;
	int gook;
	int yeong;
	int soo;
};

bool compare(Student a, Student b){
	if(a.gook != b.gook) return a.gook > b.gook;
	else{
		if(a.yeong != b.yeong) return a.yeong < b.yeong;
		else{
			if(a.soo != b.soo) return a.soo > b.soo;
			else return a.name < b.name;
		}
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	int N;
	cin >> N;
	string n;
	int g, y, s;
	Student* arr = new Student[N];
	for(int i=0; i<N; i++){
		cin >> arr[i].name >> arr[i].gook >> arr[i].yeong >> arr[i].soo;
	}
	sort(arr, arr+N, compare);
	for(int i=0; i<N; i++){
		cout << arr[i].name << '\n';
	}
}