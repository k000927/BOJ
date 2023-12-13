import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    String str = "";
    for (int i = 0; i < n; i += 4) {
      str += "long ";
    }
    str += "int";
    System.out.println(str);
    s.close();
  }
}
