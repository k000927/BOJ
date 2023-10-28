#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
	int N, temp;
	vector<int> v;
	cin >> N;
	for(int i=0; i<N; i++){
		scanf("%d", &temp);
		v.push_back(temp);
	}
	stable_sort(v.begin(), v.end());
	
	int M;
	cin >> M;
	for(int i=0; i<M; i++){
		scanf("%d", &temp);
		printf("%ld ", upper_bound(v.begin(), v.end(), temp) - lower_bound(v.begin(), v.end(), temp));
	}
	cout << endl;
}