#include <iostream>
#include <queue>
using namespace std;

int main(){
	int N;
	cin >> N;
	queue<int> q;
	for(int i=1; i<N+1; i++){
		q.push(i);
	}
	for(int i=0; i<N-1; i++){
		q.pop();
		q.push(q.front());
		q.pop();
	}
	cout << q.front() << endl;
}