import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int leftBalloon;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        leftBalloon = n;
        int[] balloons = new int[n];
        Arrays.fill(balloons, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int pos = 0;
        while (true) {
            bw.write(pos + 1 + " ");
            sb.append(pos + 1).append(" ");
            balloons[pos] = 0;
            if (--leftBalloon == 0) break;

            int move = num[pos];
            if (num[pos] > 0) {
                move = (num[pos] - 1) % leftBalloon + 1;
                int cnt = 0;
                while (cnt < move) {
                    if (++pos >= n) pos %= n;
                    cnt += balloons[pos];
                }
            } else {
                move = ((move * -1 - 1) % leftBalloon + 1) * -1;
                int cnt = 0;
                while (cnt > move) {
                    if (--pos < 0) pos = n + pos;
                    cnt -= balloons[pos];
                }
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }
}