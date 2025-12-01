import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] D, dp;

    static List<Integer> numList;

    static boolean[] flag;

    static void combination(int index, int bitCount) {
        if (bitCount == 0) {
            int num = 0;
            for (int i = 0; i < N; i++) {
                if (flag[i]) {
                    num |= (1 << i);
                }
            }
            numList.add(num);
        } else {
            if (index == N)
                return;
            flag[index] = true;
            combination(index + 1, bitCount - 1);
            flag[index] = false;
            combination(index + 1, bitCount);
        }
    }

    static void getNumList(int bitCount) {
        flag = new boolean[N];
        numList = new ArrayList<>();
        combination(0, bitCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        D = new int[N][N];
        dp = new int[N][(int) Math.pow(2, N)];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < N; j++) {
            dp[0][1 << j] = D[0][j];
        }

        for (int i = 1; i < N; i++) {
            getNumList(i);
            for (int j = 0; j < N; j++) {
                for (Integer num : numList) {
                    if (((1 << j) & num) != 0)
                        continue;

                    int index = (1 << j) | num;
                    dp[i][index] = Math.min(dp[i][index], dp[i - 1][num] + D[i][j]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < (int) Math.pow(2, N); j++) {
            ans = Math.min(ans, dp[N - 1][j]);
        }

        System.out.println(ans);
    }
}
