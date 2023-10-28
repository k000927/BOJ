#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

double ax, ay, bx, by, cx, cy, dx, dy;

double pos(double a, double b, double t){
	return a + (b-a) * (t/2000000000); 
}

double dist(double x1, double y1, double x2, double y2){
	return pow(x1-x2, 2) + pow(y1-y2, 2);
}

double binary_search(double lo, double hi){
	double p = (2*lo+hi)/3;
	double q = (lo+2*hi)/3;
	//cout << "p = " << p << ", q = " << q << '\n';
	if(hi - lo <= pow(10, -6)){
		return dist(pos(ax, bx, lo), pos(ay, by, lo), pos(cx, dx, lo), pos(cy, dy, lo));
	}
	if(dist(pos(ax, bx, p), pos(ay, by, p), pos(cx, dx, p), pos(cy, dy, p)) > dist(pos(ax, bx, q), pos(ay, by, q), pos(cx, dx, q), pos(cy, dy, q))){
		return binary_search(p, hi);
	}
	else return binary_search(lo, q);
}

void solve(){
	cin >> ax >> ay >> bx >> by >> cx >> cy >> dx >> dy;
	cout.setf(ios::fixed);
	cout.precision(10);
	cout << sqrt(binary_search(0, 2000000000)) << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	solve();
}