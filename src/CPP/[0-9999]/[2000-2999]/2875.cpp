#include <iostream>
#include <algorithm>
using namespace std;
 
int main(int argc, const char * argv[]) {
    int N, M, K;
    int a, b;
    int max = 0;
    
    cin >> N >> M >> K;
    for(int i = 0; i <= K; i++){
        a = (N - i) / 2;
        b = M - (K - i);
        if(max < min(a, b))
            max = min(a, b);
    }
    cout << max << '\n';
    
    return 0;
}
 
