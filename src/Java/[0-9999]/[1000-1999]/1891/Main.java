import java.io.*;
import java.util.*;

public class Main {
    static int d;

    static long[] lineToPos(String line) {
        long x = 0, y = 0;
        long k = (long) Math.pow(2, d - 1);

        for (int i = 0; i < d; i++) {
            if (line.charAt(i) - '0' == 1) {
                x += k;
                y += k;
            } else if (line.charAt(i) - '0' == 2) {
                y += k;
            } else if (line.charAt(i) - '0' == 4) {
                x += k;
            }

            k /= 2;
        }

        return new long[]{x, y};
    }

    static String posToLine(long[] pos) {
        StringBuilder sb = new StringBuilder();
        long x = pos[0], y = pos[1];
        long k = (long) Math.pow(2, d - 1);

        for (int i = 0; i < d; i++) {
            if (x >= k && y >= k) {
                sb.append('1');
                x -= k;
                y -= k;
            } else if (y >= k) {
                sb.append('2');
                y -= k;
            } else if (x >= k) {
                sb.append('4');
                x -= k;
            } else {
                sb.append('3');
            }

            k /= 2;
        }

        if (x != 0 || y != 0) return "-1";
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        long[] pos = lineToPos(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long dx = Long.parseLong(st.nextToken());
        long dy = Long.parseLong(st.nextToken());

        System.out.println(posToLine(new long[]{pos[0] + dx, pos[1] + dy}));
    }
}