import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] matrix = new int[n][n];
        int[] last_idx = new int[n];
        Arrays.fill(last_idx, n - 1);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1 * 1000000001;
        int max_idx = -1;
        for (int i = 0; i < n; i++) {
            max = -1 * 1000000001;
            max_idx = -1;
            for (int j = 0; j < n; j++) {
                if (max < matrix[last_idx[j]][j]) {
                    max = matrix[last_idx[j]][j];
                    max_idx = j;
                }
            }
            last_idx[max_idx]--;
        }

        System.out.println(max);
    }
}