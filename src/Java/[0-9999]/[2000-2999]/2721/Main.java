import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        long[] W = new long[301];
        long[] T = new long[302];

        T[1] = 1;
        for (int i = 2; i <= 301; i++) {
            T[i] = T[i - 1] + i;
        }

        W[1] = 3;
        for (int i = 2; i <= 300; i++) {
            W[i] = W[i - 1] + i * T[i + 1];
        }


        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(W[N]);
        }
    }
}