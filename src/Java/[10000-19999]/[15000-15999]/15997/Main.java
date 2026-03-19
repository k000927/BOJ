import java.io.*;
import java.util.*;

public class Main {
    static final int WIN = 0, DRAW = 1, LOSE = 2;
    static double[][][] P;
    static double[] ans;
    static List<String> country;

    static int[] result;

    static void updateAns() {
        int index = 0;
        double localP = 1;

        int[] scoreBoard = {0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int res = result[index++];

                if (res == WIN) {
                    scoreBoard[i] += 3;
                    localP *= P[i][j][WIN];
                } else if (res == DRAW) {
                    scoreBoard[i] += 1;
                    scoreBoard[j] += 1;
                    localP *= P[i][j][DRAW];
                } else {
                    scoreBoard[j] += 3;
                    localP *= P[i][j][LOSE];
                }
            }
        }

        int left = 2;
        for (int i = 9; i >= 0 && left > 0; i--) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                if (scoreBoard[j] == i) count++;
            }

            if (count == 0) continue;

            if (left >= count) {
                for (int j = 0; j < 4; j++) {
                    if (scoreBoard[j] == i) {
                        ans[j] += localP;
                    }
                }
                left -= count;
            } else {
                for (int j = 0; j < 4; j++) {
                    if (scoreBoard[j] == i) {
                        ans[j] += localP * ((double) left / count);
                    }
                }
                left = 0;
            }
        }
    }


    static void dfs(int index) {
        if (index == 6)
            updateAns();
        else {
            for (int i = 0; i < 3; i++) {
                result[index] = i;
                dfs(index + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        country = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            country.add(st.nextToken());
        }

        P = new double[4][4][3];
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            int indexA = country.indexOf(A);
            int indexB = country.indexOf(B);

            double p1 = Double.parseDouble(st.nextToken());
            double p2 = Double.parseDouble(st.nextToken());
            double p3 = Double.parseDouble(st.nextToken());

            P[indexA][indexB][0] = p1;
            P[indexA][indexB][1] = p2;
            P[indexA][indexB][2] = p3;

            P[indexB][indexA][0] = p3;
            P[indexB][indexA][1] = p2;
            P[indexB][indexA][2] = p1;
        }

        ans = new double[4];
        result = new int[6];
        dfs(0);

        for (int i = 0; i < 4; i++) {
            System.out.println(ans[i]);
        }
    }
}