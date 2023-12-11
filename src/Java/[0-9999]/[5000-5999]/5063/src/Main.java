import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    for (int i = 0; i < t; i++) {
      int r = s.nextInt();
      int e = s.nextInt();
      int c = s.nextInt();
      if (r > e - c) {
        System.out.println("do not advertise");
      } else if (r < e - c) {
        System.out.println("advertise");
      } else {
        System.out.println("does not matter");
      }
    }
    s.close();
  }
}
