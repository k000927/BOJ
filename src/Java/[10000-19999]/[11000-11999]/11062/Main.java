import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int[] cards;
    static int[][] max, sum;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            cards = new int[N];
            max = new int[N][N];
            sum = new int[N][N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
                max[i][i] = cards[i];
                sum[i][i] = cards[i];
            }

            for (int d = 1; d < N; d++) {
                for (int i = 0; i + d < N; i++) {
                    int j = i + d;
                    sum[i][j] = sum[i][j - 1] + cards[j];
                    max[i][j] = Math.max(cards[i] + (sum[i + 1][j] - max[i + 1][j]), (sum[i][j - 1] - max[i][j - 1]) + cards[j]);
                }
            }

            ans.append(max[0][N - 1]).append("\n");
        }
        System.out.print(ans);
    }
}