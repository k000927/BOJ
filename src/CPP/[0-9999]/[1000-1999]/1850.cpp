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

int main(){
	long long int a, b;
	cin >> a >> b;
	int E = Euclidean(a, b);
	for(int i=0; i<E; i++){
		cout << "1";
	}
	cout << endl;
}