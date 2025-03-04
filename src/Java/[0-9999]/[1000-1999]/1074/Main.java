import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
 * 1. 시작 r 인덱스, c 인덱스를 각각 curR, curC라 하고 0으로 초기화한다.
 * 2. 인덱스를 저장할 변수를 index라 하고 0으로 초기화한다.
 * 3. 현재 탐색할 위치의 가로세로 사이즈를 size라 하고 2^N으로 초기화한다.
 * 4. size == 1이 될 때까지 탐색한다.
 *    4.1. 현재 탐색 영역을 4등분한다.
 *    4.2. 왼쪽 위 영역에 해당될 경우 size/2 한 후 진행한다.
 *    4.3. 오른쪽 위 영역에 해당될 경우 size/2, curC = curC + size/2, index = index + size * size / 4한 후 진행한다.
 *    4.4. 왼쪽 아래 영역에 해당될 경우 size/2, curR = curR + size/2, index = index + size * size / 2한 후 진행한다.
 *    4.5. 오른쪽 아래 영역에 해당될 경우 size/2, curC = curC + size/2, curR = curR + size/2, index = index + size * size * 3/4한 후 진행한다.
 * 5. index를 출력한다.
 */

public class Main {

  static final StreamTokenizer st = new StreamTokenizer(
    new BufferedReader(new InputStreamReader(System.in))
  );

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int targetR = nextInt();
    int targetC = nextInt();

    int index = 0;
    int curR = 0;
    int curC = 0;

    int size = (int) Math.pow(2, n);
    while (size > 1) {
      if (targetR >= curR + size / 2) {
        curR += size / 2;
        index += size * size / 2;
      }

      if (targetC >= curC + size / 2) {
        curC += size / 2;
        index += size * size / 4;
      }

      size /= 2;
    }

    System.out.println(index);
  }

  private static int nextInt() throws IOException {
    st.nextToken();
    return (int) st.nval;
  }
}
