import java.io.*;
import java.util.*;

public class Main {
    static int b1, b2, b3, k1, k2;
    static boolean[][] result;

    static void init() {
        result = new boolean[501][501];
        result[0][0] = true;

        for (int i = 0; i <= 500; i++) {
            for (int j = 0; j <= 500; j++) {
                boolean temp = true;
                if (i >= b1) temp &= !result[i - b1][j];
                if (i >= b2) temp &= !result[i - b2][j];
                if (i >= b3) temp &= !result[i - b3][j];

                if (j >= b1) temp &= !result[i][j - b1];
                if (j >= b2) temp &= !result[i][j - b2];
                if (j >= b3) temp &= !result[i][j - b3];

                result[i][j] = temp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        b1 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());
        b3 = Integer.parseInt(st.nextToken());

        init();

        for (int t = 0; t < 5; t++) {
            st = new StringTokenizer(br.readLine());
            k1 = Integer.parseInt(st.nextToken());
            k2 = Integer.parseInt(st.nextToken());

            ans.append(!result[k1][k2] ? 'A' : 'B').append('\n');
        }

        System.out.print(ans);
    }
}