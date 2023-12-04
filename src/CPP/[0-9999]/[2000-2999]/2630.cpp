#include <iostream>
using namespace std;

int blueCount = 0;
int whiteCount = 0;
bool** arr;
void isColor(int x, int y, int width) {
  bool color = arr[x][y];
  for (int i = x; i < x + width; i++) {
    for (int j = y; j < y + width; j++) {
      if (color != arr[i][j]) {
        int new_width = width / 2;
        isColor(x, y, new_width);
        isColor(x, y + new_width, new_width);
        isColor(x + new_width, y, new_width);
        isColor(x + new_width, y + new_width, new_width);
        return;
      }
    }
  }
  if (color)
    blueCount++;
  else
    whiteCount++;
}

void solve() {
  int n;
  cin >> n;
  arr = new bool*[n];
  for (int i = 0; i < n; i++) {
    arr[i] = new bool[n];
    for (int j = 0; j < n; j++) {
      cin >> arr[i][j];
    }
  }
  isColor(0, 0, n);
  cout << whiteCount << endl << blueCount << endl;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  solve();
}