import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String T, P;

    static int[] failure;

    static void makeFailure() {
        failure[0] = 0;
        int j = 0;
        for (int i = 1; i < P.length(); i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = failure[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                j++;
                failure[i] = j;
            } else {
                failure[i] = 0;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = br.readLine();
        P = br.readLine();
        failure = new int[P.length()];

        makeFailure();

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        int j = 0;
        for (int i = 0; i < T.length(); i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = failure[j - 1];
            }
            if (T.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    cnt++;
                    sb.append((i - P.length() + 2) + " ");
                    j = failure[j];
                } else {
                    j++;
                }
            }
        }


        System.out.println(cnt + "\n" + sb);
    }
}
