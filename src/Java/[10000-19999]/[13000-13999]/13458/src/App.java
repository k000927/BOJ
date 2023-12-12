import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = s.nextInt();
    }
    int b = s.nextInt();
    int c = s.nextInt();
    long ans = 0;
    for (int i = 0; i < n; i++) {
      ans += 1;
      a[i] -= b;
      if (a[i] > 0) {
        ans += (int) Math.ceil((double) a[i] / c);
      }
    }
    System.out.println(ans);
    s.close();
  }
}
