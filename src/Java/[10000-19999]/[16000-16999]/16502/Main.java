import java.io.*;
import java.util.*;

public class Main {
    static int T, M;
    static double[][] P = new double[4][4];
    static double[] ans = new double[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = st.nextToken().charAt(0) - 'A';
            int to = st.nextToken().charAt(0) - 'A';
            double p = Double.parseDouble(st.nextToken());

            P[from][to] = p;
        }

        for (int i = 0; i < 4; i++) {
            double[][] curAns = new double[T + 1][4];
            curAns[0][i] = 1;

            for (int t = 1; t <= T; t++) {
                for (int from = 0; from < 4; from++) {
                    for (int to = 0; to < 4; to++) {
                        curAns[t][to] += curAns[t - 1][from] * P[from][to];
                    }
                }
            }

            for (int j = 0; j < 4; j++) {
                ans[j] += curAns[T][j] * 25;
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(ans[i]);
        }
    }
}