import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        int[][] rowSum = new int[n][2]; // 가로
        int[][] colSum = new int[m][2]; // 세로
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (j == 0 || j == m - 1) {
                    sum1 += a[i][j];
                    sum2 += a[i][j] * 2;
                } else {
                    sum1 += a[i][j] * 2;
                    sum2 += a[i][j] * 4;
                }
            }
            rowSum[i][0] = sum1;
            rowSum[i][1] = sum2;
            totalSum += sum2;
        }

        totalSum -= rowSum[0][1];
        totalSum -= rowSum[n - 1][1];
        totalSum += rowSum[0][0];
        totalSum += rowSum[n - 1][0];


        for (int j = 0; j < m; j++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0 || i == n - 1) {
                    sum1 += a[i][j];
                    sum2 += a[i][j] * 2;
                } else {
                    sum1 += a[i][j] * 2;
                    sum2 += a[i][j] * 4;
                }
            }
            colSum[j][0] = sum1;
            colSum[j][1] = sum2;
        }

        int ans = totalSum;
        totalSum -= rowSum[0][0];
        totalSum += rowSum[0][1];
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, totalSum - rowSum[i][1] + rowSum[i][0]);
        }
        totalSum += rowSum[0][0];
        totalSum -= rowSum[0][1];


        totalSum -= rowSum[n - 1][0];
        totalSum += rowSum[n - 1][1];
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, totalSum - rowSum[i][1] + rowSum[i][0]);
        }
        totalSum += rowSum[n - 1][0];
        totalSum -= rowSum[n - 1][1];


        totalSum -= colSum[0][0];
        totalSum += colSum[0][1];
        for (int i = 1; i < m - 1; i++) {
            ans = Math.max(ans, totalSum - colSum[i][1] + colSum[i][0]);
        }
        totalSum += colSum[0][0];
        totalSum -= colSum[0][1];

        totalSum -= colSum[m - 1][0];
        totalSum += colSum[m - 1][1];
        for (int i = 1; i < m - 1; i++) {
            ans = Math.max(ans, totalSum - colSum[i][1] + colSum[i][0]);
        }

        System.out.println(ans);
    }
}