#include <iostream>
using namespace std;

int main(){
	int x, y, w, h;
	cin >> x >> y >> w >> h;
	int ans = min(x, w-x) < min(y, h-y) ? min(x, w-x) : min(y, h-y);
	cout << ans << endl;
}