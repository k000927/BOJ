#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int main(){
	int N, temp, count;
	int arr[8001] = {0,};
	cin >> N;
	double sum = 0;
	count = 0;
	vector <int> v;
	for(int i=0; i<N; i++){
		cin >> temp;
		v.push_back(temp);
		arr[temp+4000]++;
		sum += (double)temp;
		count++;
	}
	int max = -1;
	vector <int> m;
	for(int i=0; i<8001; i++){
		if(max<arr[i]) {
			m.clear();
			m.push_back(i-4000);
			max = arr[i];
		}
		else if(max==arr[i]){
			m.push_back(i-4000);
		}
	}
	stable_sort(v.begin(), v.end());
	cout << floor(sum/count + 0.5) << endl;
	cout << v[v.size()/2] << endl;
	if(m.size() == 1) cout << m[0] << endl;
	else{
		stable_sort(m.begin(), m.end());
		cout << m[1] << endl;
	}
	cout <<  v[v.size()-1] - v[0] << endl;
}