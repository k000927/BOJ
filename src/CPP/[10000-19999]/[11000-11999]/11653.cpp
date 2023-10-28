#include <iostream>
#include <vector>
using namespace std;

int prime[10000001] = {0,};


void solve(){
	int N;
	cin >> N;
	if(N==1) return;
	vector<int> v;
	if(!prime[N]){
		cout << N << endl;
		return;
	}
	int num = 2;
	while(prime[N]){
		if(prime[num]) num++;
		else{
			if(N%num == 0){
				v.push_back(num);
				N /= num++;
				num = 2;
			}
			else num++;
		}
	}
	if(N != 1) v.push_back(N);
	for(int i=0; i<v.size(); i++){
		cout << v[i] << '\n';
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	prime[0] = 1;
	prime[1] = 1;
	for(int i=2; i*i<10000001; i++){			// 1 -> 소수 아님, 0 -> 소수
    	if(prime[i] == 0) {
			for(int j = i*i; j<10000001; j+=i) prime[j] = 1;
		}
	}
	solve();
}