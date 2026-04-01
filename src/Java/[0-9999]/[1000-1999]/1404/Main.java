import java.io.*;
import java.util.*;

public class Main {
    static double[][] p = new double[8][8];
    static double[] ans = new double[8];
    static double sum;
    static Deque<Integer> player = new ArrayDeque<>();

    static void calc(int resInt) {
        double r = 1;
        for (int i = 0; i < 8; i++) {
            player.add(i);
        }

        for (int i = 0; i < 7; i++) {
            int A = player.pollFirst();
            int B = player.pollFirst();

            boolean res = ((resInt & (1 << i)) != 0);
            if (res) {
                player.addLast(A);
                r *= p[A][B];
            } else {
                player.addLast(B);
                r *= p[B][A];
            }

            if (r == 0) {
                player.clear();
                return;
            }
        }

        int winner = player.pollFirst();
        sum += r;
        ans[winner] += r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                p[i][j] = (double) Integer.parseInt(st.nextToken()) / 100;
                p[j][i] = 1 - p[i][j];
            }
        }

        for (int i = 0; i < 128; i++) {
            calc(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb);
    }
}