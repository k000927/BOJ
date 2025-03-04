/*
 * 1. makeQuadTree(int rIndex, int cIndex, int size)
 *      1.1. size == 1일 때, video[rIndex][cIndex] 반환
 *      1.2. a = mQT(r, c, s/2), b = mQT(r, c+s/2, s/2), c = mQT(r+s/2, c, s/2), d = (r+s/2, c+s/2, s/2)
 *          1.2.1. a=b=c=d 일 때, a 반환
 *          1.2.2. 그렇지 않다면 (abcd)반환
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int[][] video;

  static String makeQuadTree(int rIndex, int cIndex, int size) {
    if (size == 1) {
      return String.valueOf(video[rIndex][cIndex]);
    }

    // 왼쪽 위
    String a = makeQuadTree(rIndex, cIndex, size / 2);
    // 오른쪽 위
    String b = makeQuadTree(rIndex, cIndex + size / 2, size / 2);
    // 왼쪽 아래
    String c = makeQuadTree(rIndex + size / 2, cIndex, size / 2);
    // 오른쪽 아래
    String d = makeQuadTree(rIndex + size / 2, cIndex + size / 2, size / 2);

    if (a.length() == 1 && a.equals(b) && a.equals(c) && a.equals(d)) {
      return a;
    } else {
      return ("(" + a + b + c + d + ")");
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    video = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        video[i][j] = br.read() - '0';
      }
      br.read();
    }

    System.out.println(makeQuadTree(0, 0, n));
  }
}
