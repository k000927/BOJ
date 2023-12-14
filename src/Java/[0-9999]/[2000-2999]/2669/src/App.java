import java.util.Arrays;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in);
    int count = 0;
    int[][] arr = new int[99][99];
    for (int i = 0; i < 99; i++) {
      Arrays.fill(arr[i], 0);
    }
    for (int i = 0; i < 4; i++) {
      int start_x = s.nextInt() - 1;
      int start_y = s.nextInt() - 1;
      int end_x = s.nextInt() - 1;
      int end_y = s.nextInt() - 1;
      for (int a = start_x; a < end_x; a++) {
        for (int b = start_y; b < end_y; b++) {
          if (arr[a][b] == 0) {
            arr[a][b] = 1;
          }
        }
      }
    }
    for (int i = 0; i < 99; i++) {
      for (int j = 0; j < 99; j++) {
        if (arr[i][j] == 1) {
          count++;
        }
      }
    }
    System.out.println(count);
    s.close();
  }
}
