import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    HashMap<String, String> map = new HashMap<>();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String start = st.nextToken();
      st.nextToken();
      String end = st.nextToken();

      map.put(start, end);
    }

    Boolean[] visited = new Boolean[26];
    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      Arrays.fill(visited, false);
      st = new StringTokenizer(br.readLine());

      String start = st.nextToken();
      st.nextToken();
      String end = st.nextToken();

      while (true) {
        String curNode = map.getOrDefault(start, "NOT_EXIST");

        if (curNode.equals("NOT_EXIST")) {
          System.out.println("F");
          break;
        }

        if (visited[(int) curNode.charAt(0) - 'a']) {
          System.out.println("F");
          break;
        }

        if (curNode.equals(end)) {
          System.out.println("T");
          break;
        }

        start = curNode;
      }
    }
  }
}
