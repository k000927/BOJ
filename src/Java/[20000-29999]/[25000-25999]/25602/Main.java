import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int[] a;
    static int ans = -1;
    static feed[][] arr;

    static class feed {
        int[] leftCan = new int[n];
        int sat;

        feed(int i, int j, int sat) {
            Arrays.fill(leftCan, 0);
            leftCan[i]++;
            leftCan[j]++;
            this.sat = sat;
        }
    }

    static void bt(int cur, int[] can, int sat) {
        for (int i = 0; i < n; i++) {
            if (can[i] > a[i]) return;
        }
        if (cur == k - 1) {
            ans = Math.max(ans, sat);
        } else {
            for (int i = 0; i < n * n; i++) {
                int curSat = sat + arr[cur + 1][i].sat;
                int[] curCan = new int[n];
                for (int j = 0; j < n; j++) {
                    curCan[j] = can[j] + arr[cur + 1][i].leftCan[j];
                }
                bt(cur + 1, curCan, curSat);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[][] R = new int[k][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] M = new int[k][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr = new feed[k][n * n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    arr[i][j * n + l] = new feed(j, l, R[i][j] + M[i][l]);
                }
            }
        }

        bt(-1, new int[n], 0);

        System.out.println(ans);
    }
}