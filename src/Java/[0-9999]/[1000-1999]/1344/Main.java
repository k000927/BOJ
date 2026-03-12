import java.io.*;

public class Main {
    static double pA, pB, notA, notB;
    static long[][] comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pA = Double.parseDouble(br.readLine()) / 100;
        pB = Double.parseDouble(br.readLine()) / 100;

        notA = notB = 0;
        if (pA == 0 || pA == 1) {
            notA = 1;
        }
        if (pB == 0 || pB == 1) {
            notB = 1;
        }


        comb = new long[19][19];
        for (int i = 0; i <= 18; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }

        boolean primeFlag;
        for (int i = 0; i <= 18; i++) {
            primeFlag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    primeFlag = false;
                    break;
                }
            }

            if (i >= 2 && primeFlag) continue;

            if (pA != 0 && pA != 1) {
                notA += comb[18][i] * Math.pow(pA, i) * Math.pow(1 - pA, 18 - i);
            }

            if (pB != 0 && pB != 1) {
                notB += comb[18][i] * Math.pow(pB, i) * Math.pow(1 - pB, 18 - i);
            }
        }

        System.out.println(1 - notA * notB);
    }
}