import java.io.*;
import java.lang.management.MemoryManagerMXBean;
import java.util.*;

public class Main {
    class point {
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Long ans = 0L;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ans += Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            ans += Long.parseLong(st.nextToken());
        }

        System.out.println(ans);
    }
}