#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0); 
	
	vector<int> v;
	int T, temp;
	cin >> T;
	for(int i=0; i<T; i++){
		cin >> temp;
		v.push_back(temp);
	}
	
	stable_sort(v.begin(), v.end());
	
	int U;
	cin >> U;
	for(int i=0; i<U; i++){
		cin >> temp;
		if(binary_search(v.begin(), v.end(), temp)) cout << 1 << '\n';
		else cout << 0 << '\n';
	}
}