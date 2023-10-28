#include <iostream>
using namespace std;

int main(){
	int T, h, w, n;
	cin >> T;
	for(int z=0; z<T; z++){
		cin >> h >> w >> n;
		int ans_w, ans_h;
		if(n%h != 0){
			ans_w = n/h + 1;
			ans_h = n%h;
		}
		else{
			ans_w = n/h;
			ans_h = h;
		}
		cout << ans_h;
		if(ans_w<10) cout << 0 << ans_w << endl;
		else cout << ans_w << endl;
	}
}