import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int[][] grow;
    static int[][] larva;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        grow = new int[n][3];
        larva = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(larva[i], 1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            grow[i][0] = Integer.parseInt(st.nextToken());
            grow[i][1] = Integer.parseInt(st.nextToken());
            grow[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int x = m - 1;
            int y = 0;

            for (int j = 0; j < 3; j++) {
                while (grow[i][j] != 0) {
                    larva[x][y] += j;
                    grow[i][j]--;
                    if (x == 0) y++;
                    else x--;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                larva[i][j] = Math.max(Math.max(larva[i - 1][j], larva[i][j - 1]), larva[i - 1][j - 1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(larva[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}