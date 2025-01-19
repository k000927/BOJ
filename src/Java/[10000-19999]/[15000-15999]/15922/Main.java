import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int ans = 0;

    static class Line {
        int start;
        int end;

        Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Line prev = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        ans += prev.end - prev.start;

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Line curr = new Line(start, end);

            if (prev.end <= curr.start) ans += curr.end - curr.start;
            else if (prev.end < curr.end) ans += curr.end - prev.end;
            else {
                start = prev.start;
                end = prev.end;
            }

            prev = new Line(start, end);
        }

        System.out.println(ans);
    }
}