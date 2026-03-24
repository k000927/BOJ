import java.io.*;
import java.util.*;

public class Main {
    static int A, B;
    static boolean[][] deck = new boolean[2][11];

    static boolean canWin(int P, int Q) {
        if (A == B) {
            if (P == Q) {
                return A > P;
            } else {
                return true;
            }
        } else {
            if (P == Q) {
                return false;
            } else {
                int my = (A + B) % 10;
                int opp = (P + Q) % 10;
                return my > opp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        if (A == B) {
            deck[0][A] = deck[1][A] = true;
        } else {
            deck[0][A] = deck[0][B] = true;
        }

        int p = 0, q = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 10; j++) {
                if (deck[i][j]) continue;
                deck[i][j] = true;
                for (int k = 0; k < 2; k++) {
                    for (int l = 1; l <= 10; l++) {
                        if (deck[k][l]) continue;
                        if (canWin(j, l)) p++;
                        q++;
                    }
                }
                deck[i][j] = false;
            }
        }

        System.out.printf("%.3f%n", (double) p / q);
    }
}