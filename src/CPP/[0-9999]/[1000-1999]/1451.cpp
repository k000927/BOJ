#include <algorithm>
#include <iostream>
using namespace std;

int getSquareNum(int** square, int startN, int endN, int startM, int endM) {
  int sum = 0;
  for (int i = startN; i <= endN; i++) {
    for (int j = startM; j <= endM; j++) {
      sum += square[i][j];
    }
  }
  return sum;
}

int getNum_1(int** square, int M) {
  int ans = -1;
  for (int i = 0; i < M - 2; i++) {
    for (int j = i + 1; j < M - 1; j++) {
      ans = max(ans, getSquareNum(square, 0, 0, 0, i) *
                         getSquareNum(square, 0, 0, i + 1, j) *
                         getSquareNum(square, 0, 0, j + 1, M));
    }
  }
  return ans;
}

int getNum_2(int** square, int N) {
  int ans = -1;
  for (int i = 0; i < N - 2; i++) {
    for (int j = i + 1; j < N - 1; j++) {
      ans = max(ans, getSquareNum(square, 0, i, 0, 0) *
                         getSquareNum(square, i + 1, j, 0, 0) *
                         getSquareNum(square, j + 1, N, 0, 0));
    }
  }
  return ans;
}

int getNum_3(int** square, int N, int M) {
  int ans = -1;
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
    }
  }
}

void solve() {
  cout << "입력하세요 >>" << endl;
  int N, M;
  cin >> N >> M;
  int** square = new int*[N];
  for (int i = 0; i < N; i++) {
    square[i] = new int[M];
  }
  for (int i = 0; i < N; i++) {
    string str;
    cin >> str;
    for (int j = 0; j < M; j++) {
      square[i][j] = str[j] - 48;
    }
  }
  if (N == 1) {
    cout << getNum_1(square, M) << endl;
  } else if (M == 1) {
    cout << getNum_2(square, N) << endl;
  }
  return;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  solve();
}