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
	cout << Euclidean(a, b) << endl << a*b/Euclidean(a,b) << endl;
}