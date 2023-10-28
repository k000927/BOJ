#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
	int n, x, y;
	cin >> n;
	vector<pair <int, int>> p;
	for(int i=0; i<n; i++){
		cin >> x >> y;
		p.push_back(make_pair(y, x));
	}
	
	sort(p.begin(), p.end());
	
	for(int i=0; i<n; i++){
		cout << p[i].second << " " << p[i].first << endl;
	}
}