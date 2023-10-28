#include <iostream>
using namespace std;

class Person{
	int height;
	int weight;
public:
	Person(int height = 0, int weight = 0){
		this->height = height;
		this->weight = weight;
	}
	int getHeight(){
		return height;
	}
	int getWeight(){
		return weight;
	}
};

int main(){
	int N, x, y;
	cin >> N;
	Person* arr = new Person[N];
	int* count = new int[N];
	int* rank = new int[N];
	for(int i=0; i<N; i++){
		cin >> x >> y;
		Person p(x, y);
		arr[i] = p;
		rank[i] = 1;
	}
	for(int i=0; i<N; i++){
		count[i] = 0;
		for(int j=0; j<N; j++){
			if(arr[i].getHeight() < arr[j].getHeight() && arr[i].getWeight() < arr[j].getWeight()) count[i]++;
		}
	}
	for(int i=0; i<N; i++){
		cout << count[i]+1 << " ";
	}
	cout << endl;
}