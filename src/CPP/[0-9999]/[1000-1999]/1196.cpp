#include <iostream>
#include <queue>
using namespace std;

int main(){
	int a;
	cin >> a;
	int n, m, impt;
	for(int i=0; i<a; i++){
		int count = 0;
		queue <pair<int, int>> q;
		priority_queue <int> pq;
		cin >> n >> m;
		for(int j=0; j<n; j++){
			cin >> impt;
			q.emplace(j, impt);
			pq.push(impt);
		}
		while(!q.empty()){
			int index = q.front().first;
			int value = q.front().second;
			q.pop();
			if(value == pq.top()){
				count++;
				pq.pop();
				if(index == m){
					cout << count << endl;
					break;
				}
			}
			else{
				q.emplace(index, value);
			}
		}
	}
}