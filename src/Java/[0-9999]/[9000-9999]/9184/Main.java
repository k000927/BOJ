import java.io.*;
import java.util.*;

public class Main {
    static int[][][] W = new int[21][21][21];

    static void init() {
        for (int a = 0; a <= 20; a++) {
            for (int b = 0; b <= 20; b++) {
                for (int c = 0; c <= 20; c++) {
                    if (a == 0 || b == 0 || c == 0) W[a][b][c] = 1;
                    else if (a < b && b < c) W[a][b][c] = W[a][b][c - 1] + W[a][b - 1][c - 1] - W[a][b - 1][c];
                    else W[a][b][c] = W[a - 1][b][c] + W[a - 1][b - 1][c] + W[a - 1][b][c - 1] - W[a - 1][b - 1][c - 1];
                }
            }
        }
    }

    static int w(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) return W[0][0][0];
        else if(a > 20 || b > 20 || c > 20) return W[20][20][20];
        else return W[a][b][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;

        int a, b, c;

        init();

        while (true) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == b && b == c && c == -1) break;

            ans.append('w')
                    .append('(').append(a).append(',').append(' ').append(b).append(',').append(' ').append(c).append(')').append(' ')
                    .append('=').append(' ').append(w(a, b, c)).append('\n');
        }

        System.out.println(ans);
    }
}