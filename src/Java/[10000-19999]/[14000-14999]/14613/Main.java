import java.io.*;
import java.util.*;

public class Main {
    static double W, L, D;
    static double[] ans = new double[5];
    static int[][] comb = new int[21][21];
    static final int BRONZE = 1500, SILVER = 2000, GOLD = 2500, PLATINUM = 3000;

    static void calc(int w, int l, int d) {
        int score = 2000 + w * 50 - l * 50;
        double p = Math.pow(W, w) * Math.pow(L, l) * Math.pow(D, d) * comb[20][w] * comb[20 - w][l];

        if (score < BRONZE) ans[0] += p;
        else if (score < SILVER) ans[1] += p;
        else if (score < GOLD) ans[2] += p;
        else if (score < PLATINUM) ans[3] += p;
        else {
            ans[4] += p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Double.parseDouble(st.nextToken());
        L = Double.parseDouble(st.nextToken());
        D = Double.parseDouble(st.nextToken());


        for (int i = 0; i <= 20; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }

        for (int w = 0; w <= 20; w++) {
            for (int l = 0; w + l <= 20; l++) {
                calc(w, l, 20 - w - l);
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.printf("%.8f\n", ans[i]);
        }
    }
}