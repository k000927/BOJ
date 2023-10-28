#include <iostream>
using namespace std;

long long int Euclidean(long long int a, long long int b)
{
    long long int r = a % b;
    if (r == 0) {
      return b;
    }
    return Euclidean(b, r);
}

void solve(){
	int T;
	cin >> T;
	for(int z=0; z<T; z++){
		int n;
		long long int sum = 0;
		cin >> n;
		long long int* arr = new long long int [n];
		for(int i=0; i<n; i++){
			cin >> arr[i];
		}
		for(int i=0; i<n-1; i++){
			for(int j=i+1; j<n; j++){
				sum += Euclidean(arr[i], arr[j]);
			}
		}
		cout << sum << '\n';
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}