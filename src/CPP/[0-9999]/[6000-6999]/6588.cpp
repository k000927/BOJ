#include <iostream>
using namespace std;

int prime[1000001] = {0,};

void solve(){
	int n;
	while(true){
		cin >> n;
		if(n == 0) break;
		int left = 3;
		int right = n-3;
		while(left <= right){
			if(!prime[left] && !prime[right])
        		if((left + right) == n)
          			break;
    		left += 2;
     		right -= 2;
		}
		if(left > right) cout << "Goldbach's conjecture is wrong." << '\n';
		else cout << n << " = " << left << " + " << right << '\n';
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	for(int i=2; i*i<1000000; i++){
    	if(prime[i]==0){
			for(int j=i*i; j<1000000; j+=i){
      			prime[j]=1;
			}
		}	
	}
	for(int i=2; i<100; i++){
		if(!prime[i]) cout << i << '\t';
	}
	solve();
}