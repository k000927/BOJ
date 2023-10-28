#include <iostream>
using namespace std;

int Euclidean(int a, int b)
{
    int r = a % b;
    if (r == 0) {
      return b;
    }
    return Euclidean(b, r);
}

int main(){
	int T;
	cin >> T;
	for(int i=0; i<T; i++){
		int a, b;
		cin >> a >> b;
		cout << a*b/Euclidean(a,b) << endl;
	}
}