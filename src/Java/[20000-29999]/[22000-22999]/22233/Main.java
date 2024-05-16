import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int left_keyword = n;
        HashMap<String, Boolean> keyword = new HashMap<>();

        for (int i = 0; i < n; i++) {
            keyword.put(br.readLine(), true);
        }

        for (int i = 0; i < m; i++) {
            String[] keywords = br.readLine().split(",");
            for (String s : keywords) {
                if (!keyword.containsKey(s)) continue;
                if (keyword.get(s)) {
                    keyword.put(s, false);
                    left_keyword--;
                }
            }
            bw.write(left_keyword + "\n");
        }

        bw.flush();
        bw.close();
    }
}